class Foo {
    String name
    Bar bar
    static constraints = {
        name(size:5..15)
        bar(nullable:true, 
            validator: { val, obj ->
                if (!val) return
                // bar name must start with same character as foo name
                if (!obj.name.startsWith(val.name[0])) {
                    return ['invalid.bar.name', val.name, obj.name]
                }
            }
        )
    }
    
    String toString() {
        name
    }
}

