insert into funcionario(codigo, nome, email, datanasc, cpf, tipo) VALUES
(201, 'Mark Johnson', 'mark.johnson@example.com', '1985-06-10', '45678901234', 'Professor'),
(202, 'Emily White', 'emily.white@example.com', '1992-03-25', '56789012345', 'Secretaria'),
(203, 'David Black', 'david.black@example.com', '1980-09-05', '67890123456', 'Administrativo'),
(204, 'Jessica Green', 'jessica.green@example.com', '1994-11-15', '78901234567', 'Professor'),
(205, 'Brian Taylor', 'brian.taylor@example.com', '1987-07-20', '89012345678', 'Secretaria'),
(206, 'Megan Davis', 'megan.davis@example.com', '1990-02-28', '90123456789', 'Administrativo'),
(207, 'Christopher Brown', 'christopher.brown@example.com', '1983-10-15', '01234567890', 'Professor'),
(208, 'Amanda Wilson', 'amanda.wilson@example.com', '1996-05-23', '11223344556', 'Secretaria'),
(209, 'Justin Miller', 'justin.miller@example.com', '1989-12-08', '22334455667', 'Administrativo'),
(210, 'Lauren Harris', 'lauren.harris@example.com', '1982-08-20', '33445566778', 'Professor'),
(211, 'Kevin Turner', 'kevin.turner@example.com', '1995-04-10', '44556677889', 'Secretaria'),
(212, 'Rachel Martinez', 'rachel.martinez@example.com', '1988-03-15', '55667788900', 'Administrativo'),
(213, 'Daniel Hall', 'daniel.hall@example.com', '1991-01-20', '66778899011', 'Professor'),
(214, 'Samantha Walker', 'samantha.walker@example.com', '1986-09-05', '77889900122', 'Secretaria'),
(215, 'Tyler Clark', 'tyler.clark@example.com', '1993-06-30', '88990011223', 'Administrativo');

insert into turma(id, nome, dia, horario, duracao, preco, funcionario) VALUES
(101, 'Tigers', 'Segunda-feira', '18:00', 60, 50.00, 201),
(102, 'Monkeys', 'Quarta-feira', '19:30', 45, 40.00, 202),
(103, 'Eagles', 'Sexta-feira', '17:45', 50, 35.00, 203),
(104, 'Sharks', 'Terca-feira', '20:00', 55, 45.00, 204),
(105, 'Tigers', 'Quinta-feira', '18:30', 75, 60.00, 205),
(106, 'Tigers', 'Sabado', '10:00', 90, 70.00, 206),
(107, 'Monkeys', 'Segunda-feira', '19:15', 50, 55.00, 207),
(108, 'Monkeys', 'Quarta-feira', '17:30', 60, 40.00, 208),
(109, 'Eagles', 'Sexta-feira', '19:00', 30, 25.00, 209),
(110, 'Eagles', 'Terca-feira', '18:45', 70, 65.00, 210),
(111, 'Sharks', 'Quinta-feira', '20:30', 60, 50.00, 211),
(112, 'Sharks', 'Sabado', '11:30', 45, 55.00, 212),
(113, 'Tigers', 'Segunda-feira', '20:15', 40, 30.00, 213),
(114, 'Eagles', 'Quarta-feira', '18:00', 50, 35.00, 214),
(115, 'Eagles', 'Sexta-feira', '17:00', 55, 45.00, 215);

insert into matricula(id, data, aulaexp, turma) VALUES
(1, '2023-01-15', true, 101),
(2, '2023-02-20', false, 102),
(3, '2023-03-10', true, 103),
(4, '2023-04-05', true, 104),
(5, '2023-05-12', false, 105),
(6, '2023-06-20', true, 106),
(7, '2023-07-08', true, 107),
(8, '2023-08-25', false, 108),
(9, '2023-09-15', true, 109),
(10, '2023-10-23', true, 110),
(11, '2023-11-08', false, 111),
(12, '2023-12-10', true, 112),
(13, '2024-01-20', true, 113),
(14, '2024-02-15', false, 114),
(15, '2024-03-30', true, 115);


insert into aluno(codigo, nome, email, datanasc, cpf, telefone, matricula) VALUES
(1, 'John Doe', 'john.doe@example.com', '1990-01-01', '12345678901', '123-456-7890', 1),
(2, 'Jane Smith', 'jane.smith@example.com', '1995-05-15', '23456789012', '987-654-3210', 2),
(3, 'Alice Johnson', 'alice.johnson@example.com', '1988-11-30', '34567890123', '555-123-4567', 3),
(4, 'Bob Williams', 'bob.williams@example.com', '1992-08-20', '45678901234', '321-654-9870', 4),
(5, 'Eva Davis', 'eva.davis@example.com', '1987-04-05', '56789012345', '789-012-3456', 5),
(6, 'Chris Taylor', 'chris.taylor@example.com', '1998-12-12', '67890123456', '987-654-3210', 6),
(7, 'Sophia Brown', 'sophia.brown@example.com', '1985-07-18', '78901234567', '111-222-3333', 7),
(8, 'Daniel Lee', 'daniel.lee@example.com', '1993-02-28', '89012345678', '444-555-6666', 8),
(9, 'Olivia Moore', 'olivia.moore@example.com', '1980-09-15', '90123456789', '777-888-9999', 9),
(10, 'Michael Turner', 'michael.turner@example.com', '1991-06-23', '01234567890', '999-000-1111', 10),
(11, 'Ava Clark', 'ava.clark@example.com', '1983-03-08', '11223344556', '222-333-4444', 11),
(12, 'William Baker', 'william.baker@example.com', '1996-11-10', '22334455667', '555-666-7777', 12),
(13, 'Emma Hall', 'emma.hall@example.com', '1982-05-20', '33445566778', '888-999-0000', 13),
(14, 'Henry Walker', 'henry.walker@example.com', '1994-04-15', '44556677889', '000-111-2222', 14),
(15, 'Grace Martinez', 'grace.martinez@example.com', '1989-08-30', '55667788900', '333-444-5555', 15);


insert into pagamento(id, valor, data, matricula) VALUES
(1, 100.00, '2023-01-20', 1),
(2, 150.00, '2023-02-25', 2),
(3, 120.00, '2023-03-15', 3),
(4, 200.00, '2023-04-10', 4),
(5, 90.00, '2023-05-18', 5),
(6, 180.00, '2023-06-25', 6),
(7, 130.00, '2023-07-15', 7),
(8, 250.00, '2023-08-30', 8),
(9, 160.00, '2023-09-20', 9),
(10, 210.00, '2023-10-28', 10),
(11, 120.00, '2023-11-15', 11),
(12, 300.00, '2023-12-18', 12),
(13, 170.00, '2024-01-25', 13),
(14, 220.00, '2024-02-20', 14),
(15, 190.00, '2024-03-15', 15);


insert into frequencia(id, presenca, data, matricula) VALUES
(1, true, '2023-01-16', 1),
(2, false, '2023-02-21', 2),
(3, true, '2023-03-11', 3),
(4, true, '2023-04-06', 4),
(5, false, '2023-05-13', 5),
(6, true, '2023-06-21', 6),
(7, true, '2023-07-10', 7),
(8, false, '2023-08-26', 8),
(9, true, '2023-09-16', 9),
(10, true, '2023-10-24', 10),
(11, false, '2023-11-09', 11),
(12, true, '2023-12-11', 12),
(13, true, '2024-01-21', 13),
(14, false, '2024-02-16', 14),
(15, true, '2024-03-31', 15);

