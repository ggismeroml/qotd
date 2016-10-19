package qotd

class QuoteController {

    static defaultAction = "home"

    /*def index() { }*/

    def home() {
        render "<h1>Real Programmers do not eat Quiche</h1>"
    }

    def random() {
        /*def staticAuthor = "Anonymous"
        def staticContent = "Real Programmers don't eat much quiche"
        [ author: staticAuthor, content: staticContent]*/

        /*def staticQuote = new Quote(author: "Anonymous", content: "Real Programmers don't eat much Quiche")
        [quote: staticQuote]*/

        def allQuotes = Quote.list()
        def randomQuote
        if(allQuotes.size() > 0) {
            def randomIdx = new Random().nextInt(allQuotes.size())
            randomQuote = allQuotes[randomIdx]
        } else {
            randomQuote = new Quote(author: "Anonymous",
                    content: "Real Programmers don't eat much Quiche")
        }
        [quote: randomQuote]
    }
}
