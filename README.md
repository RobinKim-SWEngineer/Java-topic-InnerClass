# Java-topic-InnerClass

In java there are two kinds of inner classes, one is **local class** and another is **anonymous class**.

Anonymous class is like local class, but it is a *expression* while local class is itself, a *declaration*.

With Anonymous class we can define and instantiate a class at the same time.

For example when a method requires an object of type an interface, we can use an anonymous class instead of implementing the mothod ( in the interface ) with a new class. 

>   public final void setOnAction ( EventHandler< ActionEvent> value )

    
    btn.setOnAction( new EventHandler< ActionEvent>() {
        @override
        public void OnAction(ActionEvent evevnt) {
            // Something with event    
        }
    });
