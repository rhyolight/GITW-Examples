class Bar {
    String name
    
    static hasMany = [links:FooBarLink]
    
    static constraints = {
    }
    
    def getFoos() {
        links*.foo
    }
    
    def addToFoos(foo) {
        foo.save()
        foo.addToBars(this)
    }
    
    String toString() { name }
    
}
