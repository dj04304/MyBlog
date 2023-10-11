let index = {
	init: function() {
		$("#btn-save").on("click", ()=> { // this를 바인딩하기위한 화살표함수
			this.save();
		});
		$("#btn-delete").on("click", ()=> { // this를 바인딩하기위한 화살표함수
			this.deleteById();
		});
	},
	
	save: function() {
		let data ={
			title: $("#title").val(),
			content: $("#content").val()
		}
		
		 console.log(data); //js
		 console.log(JSON.stringify(data)); //JSON data
		
		//회원가입 수행 요청 
		// default가 비동기 호출
		//ajax 통신을 이용해 3개의 데이터를 json으로 변경하여 insert 요청
		
		$.ajax({
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data), //http body data
			contentType: "application/json; charset=utf-8", //body data 의 contentType
			dataType: "json" //응답이 왔을 때 기본적으로 모든 것이 String으로 온다. (생긴게 JSON이라면 javascript오브젝트로 변경)
		}).done(function(resp){
			alert("글쓰기 완료");
			console.log(resp);
			location.href= "/"
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
		
	},
	
	deleteById: function() {
		let id = $("#id").text();
		
		$.ajax({
			type: "DELETE",
			url: "/api/board/" + id,
			dataType: "json" //응답이 왔을 때 기본적으로 모든 것이 String으로 온다. (생긴게 JSON이라면 javascript오브젝트로 변경)
		}).done(function(resp){
			alert("게시글 삭제 완료");
			console.log(resp);
			location.href= "/"
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
		
	},
	
	
}

index.init();