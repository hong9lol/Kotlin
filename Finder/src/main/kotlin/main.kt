package domain
import org.w3c.dom.events.Event
import kotlin.browser.document
import kotlinx.browser.document

external val bodyText: dynamic
external fun init()
external fun alert(arg: dynamic)
external fun startProcess(arg: String)

fun main() {
    document.write("Hello, world!")
    init()


    fun test(arg: dynamic) {
        alert(arg)
    }

//    js("alert(\"OK!!!\");")
//    js("chrome.tabs.executeScript({\n" +
//            "    code:'document.querySelector(\"body\").innerHTML'\n" +
//            "}, function(result){\n" +//            "    alert(\"hello\");\n" +
//            "});");

    alert(bodyText)
}

fun selectDOMNode(){
    val saveButton= document.getElementById("saveBtn")
//    saveButton?.addEventListener("click”, save)
    // saveButton?.addEventListener("click”, { alert(“on click event”} ….. 이렇게도 가능할거 같음
}

//https://www.slipp.net/wiki/pages/viewpage.action?pageId=30769702