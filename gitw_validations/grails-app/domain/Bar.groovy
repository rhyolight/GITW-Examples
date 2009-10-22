class Bar {
    String name
    static belongsTo = [foo:Foo]
    static constraints = {
        foo(nullable:true)
    }
    
    String toString() {
        name
    }
}
