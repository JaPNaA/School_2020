echo "OwO what's this?"
echo ""
echo "It looks like there is an absence of j..."
echo "What's j, you ask? It's shortcut that compiles and runs java programs, so you don't have to keep typing 'javac this.java' and 'java that'."
echo ""
echo "UwU that's enough explaining from me, just try it yourself: type the command installj"
echo ""
echo ""
echo "... if you don't that's fine as well, just don't (run the command) hurtMe. I'm just the messager. I was sent by Leo... I mean uh, Leonardo DaVinchi."


installj() {
    echo "   _____              _____     "
    echo "  /      \           /      \   "
    echo " |        |         |        |  "
    echo " |        |         |        |  "
    echo " |        |    w    |        |  "
    echo "  \______/           \______/   "
    echo ""
    echo ""
    sleep 2
    echo "What's this, you have summoned me?"
    sleep 2
    echo "To perform the ritual?"
    sleep 2
    echo "Very well"
    sleep 2

    for i in {1..10}
    do
        _showRandom
        sleep $(( $i / 10 ))
    done

    sleep 1
    _showRandom
    sleep 2
    echo ...
    sleep 1
    echo "that didn't work."
    sleep 2
    echo "maybe i'll try the less satanic method. hold on."
    sleep 1
    curl https://raw.githubusercontent.com/JaPNaA/School_2020/master/j.sh > ~/.j.sh
    echo "source ~/.j.sh" > ~/.profile
    echo "K done"

    source ~/.profile
}

_showRandom() {
    head /dev/urandom -c 2000 | perl -lpe '$_=unpack"H*"'
}

hurtMe() {
    echo "   _____              _____     "
    echo "  /      \           /      \   "
    echo " |        |         |        |  "
    echo " |        |         |        |  "
    echo " |        |    w    |        |  "
    echo "  \______/           \______/   "
    echo ""
    echo ""
    sleep 2
    echo "What's this, you have summoned me?"
    sleep 2
    echo "To perfo... WHAT'S THAT IN YOUR HAND?!"
    sleep 2
    echo "OH GOD I SAID I'M JUST THE MESSENGER"
    sleep 2

    for i in {1..10}
    do
        _showRandom
        sleep $(( $i / 10 ))
    done

    sleep 1
    _showRandom
    sleep 2
    echo ...
    sleep 1
    echo "Why--- tell me wife.. i love her--------"
    sleep 2
    echo "echo \"You grieve for the messanger's death\"" > ~/.profile
}
