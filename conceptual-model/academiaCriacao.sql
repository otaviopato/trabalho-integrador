create database academia;

\c academia;



create table funcionario(
       codigo       integer not null,
       nome     varchar(40) not null,
       email     varchar(40),
       datanasc    date not null,
       cpf    varchar(11) not null,
       tipo    varchar(15) not null,
       constraint pk_funcionario primary key (codigo)
);
create table turma(
       id       integer not null,
       nome     varchar(40) not null,
       dia    varchar(15) not null,
       horario    varchar(5) not null,
       duracao    integer not null,
       preco      numeric (10,2)  not null,
       funcionario       integer not null,
       constraint pk_turma primary key (id),
       constraint fk_turma_funcionario foreign key (funcionario) references funcionario(codigo)
);
create table matricula(
       id       integer not null,
       data    date not null,
       aulaexp    bool,
       turma integer,
       constraint pk_matricula primary key (id),
       constraint fk_matricula_turma foreign key (turma) references turma(id)
);
create table pagamento(
       id       integer not null,
       valor     numeric (10,2) not null,
       data    date not null,
       matricula integer not null,
       constraint pk_pagamento primary key (id,data),
       constraint fk_pagamento_matricula foreign key (matricula) references matricula(id)
);
create table frequencia(
       id       integer not null,
       presenca bool not null,
       data    date not null,
       matricula integer not null,
       constraint pk_frequencia primary key (id,data),
       constraint fk_frequencioa_matricula foreign key (matricula) references matricula(id)
);
create table aluno(
       codigo       integer not null,
       nome     varchar(40) not null,
       email     varchar(40),
       datanasc    date not null,
       cpf    varchar(11) not null,
       telefone    varchar(15) not null,
       matricula integer,
       constraint pk_aluno primary key (codigo),
       constraint fk_aluno_matricula foreign key (matricula) references matricula(id)
);


