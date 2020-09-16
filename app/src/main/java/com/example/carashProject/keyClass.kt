package com.example.carashProject

class keys{
    var keyImage:Int?=null
    var keyName:String?=null
    var sendedValue:String?=null
    constructor(keyName:String, sendedValue:String,keyImage:Int){
        this.keyImage = keyImage
        this.keyName = keyName
        this.sendedValue = sendedValue
    }
    fun returnSendedValue(): String? {
        return this.sendedValue
    }

}