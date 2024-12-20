-- 스프링부트가 실행될 때 h2 데이터베이스에 이 쿼리를 자동으로 실행한다. h2 데이터베이스에 접속해보면 테이블이 생성된 것을 확인할 수 있음.
-- ultimate버전이 아니면 .sql파일을 지원하지 않는다고 해서 이게 안되나 하고 걱정했는데 그렇지는 않네ㅋㅋ

create table course (
    id bigint not null,
    name varchar(255) not null,
    author varchar(255) not null,
    primary key(id)
);