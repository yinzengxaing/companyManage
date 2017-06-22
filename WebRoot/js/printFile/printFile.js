$(function(){
	FileInit();
});

function FileInit(){
	$("body").on("click", "#printed", function(){
		document.body.innerHTML = document.getElementById("printModal").innerHTML;
		window.print();
		location.reload();
	});
}