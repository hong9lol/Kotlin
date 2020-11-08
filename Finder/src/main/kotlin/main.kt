import kotlinx.browser.document

fun main() {
    document.write("Hello, world!")
    js("chrome.tabs.executeScript({\n" +
            "    code:'document.querySelector(\"body\").innerHTML'\n" +
            "}, function(result){\n" +
            "    alert(\"hello\");\n" +
            "});");

}