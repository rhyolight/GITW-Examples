class BootStrap {

     def init = { servletContext ->
         
         def matt = new Foo(name:'Matt', color:'blue').save()
         def trin = new Foo(name:'Trinity', color:'green').save()
         def dean = new Foo(name:'Dean', color:'red').save()
         def romy = new Foo(name:'Romy', color:'pink').save()
         
         new Bar(name:'Mel Gibson', foo: dean,
            image:'Mel_Gibson_controversy_figure.jpg').save()
         new Bar(name:'anglerfish', foo: matt,
            image:'anglerfish.jpg').save()
         new Bar(name:'mangatar', foo: matt,
            image:'faceyourmanga_avatar.jpg').save()
         new Bar(name:'ghost', foo: trin,
            image:'rhyolight_100.jpg').save()
         new Bar(name:'Rico', foo: romy,
            image:'rico.jpg').save()
         new Bar(name:'Sonny', foo: trin,
            image:'sonny.jpg').save()
         new Bar(name:'Tsar', foo: dean,
            image:'spaceboy_avatar.jpg').save()
         new Bar(name:'zombie', foo: romy,
            image:'zombie.jpg').save()
         
     }
     def destroy = {
     }
} 