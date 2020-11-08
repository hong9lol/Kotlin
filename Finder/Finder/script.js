chrome.tabs.executeScript({
    code:'document.querySelector("body").innerHTML'
}, function(result){
    alert("hello");
});