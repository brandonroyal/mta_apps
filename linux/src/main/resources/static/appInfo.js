$(function(){
	$.getJSON("/appInfo/labels", function (data) {
		console.log(data);
		
		var output = "";
		for(var i=0; i<data.length; i++) {
			var info = data[i];
			output += "<b>" + info.label + ":</b> " + info.value + "<br/>";
		}
		

		$("#appInfoDetails").html(output);
	});
});