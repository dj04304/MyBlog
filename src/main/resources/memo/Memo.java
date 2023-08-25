메모장

영속성 컨텍스트

모든요청은 Controller에 모인다. 이런 요청을 받았을 때 insert, update, delete, select 등을 한다. 

JPA에서는 @Transaction이 끝나는 시점에 엔티티객체를 데이터베이스에 집어넣게 되는데, 그래서 select하여 save하지 않아도 DB에 알아서 들어가게 되는것이다.

이는 영속성 컨텍스트가 관리하는 엔티티만 적용되는 것이다.

