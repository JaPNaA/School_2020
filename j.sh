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


    if [ ${#toBeCompiled[@]} -eq 0 ]; then
        echo "No files to compile"
    else
        echo Compiling changed files: $toBeCompiled...
        javac $toBeCompiled -d .build

        #

        for i in "${!hashedFilesNames[@]}"
        do
            echo ${hashedFilesHashes[i]} > $buildDirectory/${hashedFilesNames[i]}$shaFileExtention
        done
    fi

    if [ $? -eq 0 ]; then
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

