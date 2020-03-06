j() {
    currentDir=$(pwd)
    filename="${1%.*}"

    javac *.java -d .build
    cd .build

    java $filename
    cd $currentDir
}

