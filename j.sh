j() {(

    set -e

    currentDir=$(pwd)
    filename="${1%.*}"
    buildDirectory=".build"
    shaFileExtention=".shasum"

    javaFiles=( $(echo *.java **/*.java) )
    toBeCompiled=()

    hashedFilesNames=()
    hashedFilesHashes=()


    # Loop through java files, filter for changed files using .shasum files

    for javaFile in $javaFiles
    do
        # [ -f "$javaFile" ] || continue

        shaSum=$(sha256sum $javaFile | cut -d " " -f 1)
        oldShaSum="$(cat "$buildDirectory/$javaFile$shaFileExtention" 2>/dev/null || echo "")"

        if [[ "$oldShaSum" != "$shaSum" ]]; then
            toBeCompiled+=( $javaFile )
            hashedFilesNames+=( $javaFile )
            hashedFilesHashes+=( $shaSum )
        fi
    done


    # Compile

    if [ ${#toBeCompiled[@]} -eq 0 ]; then
        echo "No files to compile"
    else
        _jTestCompileIfShould

        echo Compiling changed files: $toBeCompiled...
        javac $toBeCompiled -d .build

        # Update .shasum files

        for i in "${!hashedFilesNames[@]}"
        do
            echo ${hashedFilesHashes[i]} > $buildDirectory/${hashedFilesNames[i]}$shaFileExtention
        done
    fi


    # Run, if compile successful

    if [ $? -eq 0 ]; then

        _jTestRunIfShould

        echo ""
        echo --- Running ---
        echo ""

        cd .build
        java $filename
        cd $currentDir
    else
        echo "Failed to compile"
    fi

)}


_jTestCompileIfShould() {
    if [ "$J_DISABLE_OCCASIONAL_TESTING" = "1" ]; then
        return
    elif [ -f /tmp/java.j.occasionalTesting.compile ]; then
        # checks if they've already done it once this session
        return
    else
        _jOccasionalTesting_compile
        echo "1" > /tmp/java.j.occasionalTesting.compile
    fi
}

_jTestRunIfShould() {
    if [ "$J_DISABLE_OCCASIONAL_TESTING" = "1" ]; then
        return
    elif [ -f /tmp/java.j.occasionalTesting.run ]; then
        return
    else
        _jOccasionalTesting_run
        echo "1" > /tmp/java.j.occasionalTesting.run
    fi
}

_jOccasionalTesting_prefix() {
    echo -e "\033[35;1m" # Escape code bright magenta
    echo "To disable occasional testing, add the following line to your \".profile\" file:"
    echo "  export J_DISABLE_OCCASSIONAL_TESTING=1"
    echo ""
    echo ""
    echo "Because you're using j, you probably won't remember how to compile and run."
    echo "And you're in a computer science course, so you _should_ probably know."
    echo ""
    echo "So, let's test you."
}

_jOccasionalTesting_suffix() {
    echo -e "\033[0m" # Escape code reset
}

_jOccasionalTesting_compile() {
    _jOccasionalTesting_prefix

    echo "What command would you type to COMPILE \"SomeClass.java\"?"

    while :
    do
        read -p "$ " command

        if [ "$command" = "javac SomeClass.java" ]; then
            echo "You're right!"
            break
        else
            echo "You're wrong. The answer is \"javac SomeClass.java\""
            echo "Remember: capitalization matters."
            echo "Try again"
        fi
    done

    _jOccasionalTesting_suffix
}

_jOccasionalTesting_run() {
    _jOccasionalTesting_prefix

    echo "What command would you type to RUN \"SomeClass.class\"? (the compiled version of \"SomeClass.java\")"

    while :
    do
        read -p "$ " command

        if [ "$command" = "java SomeClass" ]; then
            echo "You're right!"
            break
        else
            echo "You're wrong. \"java SomeClass\""
            echo "Remember: capitaliztaion matters."
        fi
    done

    _jOccasionalTesting_suffix
}

