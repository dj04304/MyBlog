메모장

영속성 컨텍스트

모든요청은 Controller에 모인다. 이런 요청을 받았을 때 insert, update, delete, select 등을 한다. 

JPA에서는 @Transaction이 끝나는 시점에 엔티티객체를 데이터베이스에 집어넣게 되는데, 그래서 select하여 save하지 않아도 DB에 알아서 들어가게 되는것이다.

이는 영속성 컨텍스트가 관리하는 엔티티만 적용되는 것이다.


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


Ajax를 사용하는 이유

1. 요청에 대한 응답을 html이 아닌 data(Json)를 받기 위해서

쉽게말해서 브라우저가 메인 페이지를 요청하는 것을 서버가 response해줄 때 html을 return해주면 되지만, 앱이 요청할 경우에는 앱은 자체적으로 메인페이지를 들고있기 때문에

java를 요청하게 되므로 data를 전달해 줘야 한다.  이렇게 되면 서버가 html을 요청해주는 브라우저용 서버 하나, data를 전달해주는 앱용 서버 하나 총 두 가지 서버가 필요하기 때문에

낭비가 된다. 

그래서 Ajax를 사용하게 되면 data(Json)를 브라우저든 앱이든 공통적으로 보내줄 수 있기 때문에 서버가 하나만 필요하다는 장점이 있다.

2. 비동기 통신을 하기 위해서이다. 

1번 부터 5번까지의 프로그램 실행 순서가 있다고 하면 비동기화 하지 않을 경우 1번실행 이후 2번실행 이후 ... 5번실행 이런식으로 프로그램이 진행되게 된다. (동기적)

이렇게 되면 5번 사용자의 경우 1번부터 4번까지 실행될 때 까지 기다려야 한다. 

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
