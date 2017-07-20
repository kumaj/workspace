package com.ca.uml.composition;

// http://stackoverflow.com/questions/26982886/uml-relationships-dashed-line-vs-solid-line
public class Husband {
    Wife bestWomanInTheWorld;

    public Husband(Wife theWife){
        this.bestWomanInTheWorld = theWife;
    }
}
