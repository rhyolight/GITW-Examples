class Foo {
    String name
    
    static hasMany = [links:FooBarLink]
    
    static constraints = {
    }
    
    def getBars() {
        links*.bar
    }
    
    def addToBars(bar) {
        bar.save()
        def link = new FooBarLink()
        link.bar = bar
        bar.addToLinks(link)
        this.addToLinks(link)
    }
    
    String toString() { name }
}
