package domain
import chrome.tabs.InjectDetails
import chrome.tabs.executeScript
import kotlinx.browser.document
import kotlinjs.common.jsonAs

external fun alert(arg: dynamic)

fun main() {

    executeScript(jsonAs<InjectDetails>().apply {
        code = document.querySelector("body")?.baseURI
    }) {
        result -> alert(result)
    }


//    js("alert(\"OK!!!\");")
//    js("chrome.tabs.executeScript({\n" +
//            "    code:'document.querySelector(\"body\").innerHTML'\n" +
//            "}, function(result){\n" +//            "    alert(\"hello\");\n" +
//            "});");
}

//fun selectDOMNode(){
//    val saveButton= document.getElementById("saveBtn")
////    saveButton?.addEventListener("click”, save)
//    // saveButton?.addEventListener("click”, { alert(“on click event”} ….. 이렇게도 가능할거 같음
//}
