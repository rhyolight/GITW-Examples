class FooBarLink {
    static belongsTo = [foo:Foo, bar:Bar]
    Date dateCreated
    static constraints = {
    }
    
    String toString() { "$foo <--> $bar" }
}
