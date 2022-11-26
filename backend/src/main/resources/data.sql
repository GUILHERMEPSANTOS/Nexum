		INSERT INTO TB_USERS (NOME, EMAIL, SENHA, CELULAR, SOBRE, IS_LOGGED) VALUES
		('Guilherme','guilherme@hotmail.com', '123' ,'11 997368699', 'O Homem mais lindo da terra!', false),
		('Vinicius','vinicius@hotmail.com', '123' ,'11 987368699', 'Homem fofo', false);

		INSERT INTO TB_SOCIAL (NOME) VALUES
        ('Facebook'),('Instagram'),('LinkedIn');

		INSERT INTO TB_USERS_ROLES (ID_USUARIO, ID_ROLE) VALUES
		(1,2),
		(2,3);

		INSERT INTO TB_HABILIDADE (NOME) VALUES
		('FIGMA'),('Premier'),('Photoshop'),('Inkscape'),('Illustrator');

		INSERT INTO TB_FREELANCER (ID_USUARIO) VALUES
		(2);

		INSERT INTO TB_CONTRATANTE (ID_USUARIO) VALUES
        (1);

		INSERT INTO TB_USERS_HABILIDADES (ID_USUARIO, ID_HABILIDADE) VALUES
		(1,1),
		(2,1);

		INSERT INTO TB_SOCIAL (NOME) VALUES
		('Facebook');

		INSERT INTO TB_SOCIAL_USER (USER_URL, ID_SOCIAL, ID_USUARIO) VALUES
		('GUILHEMRE.FACEBOOK', 1, 1),
        ('Vinicius.facebook', 1, 2);

		INSERT INTO TB_ENDERECO (CIDADE, ESTADO, id_usuario) VALUES
		('Ribeirão Pires', 'São Paulo', 1),
		('Suzano', 'São Paulo', 2);

		INSERT INTO TB_MATCH  (STATUS , CONTRATANTE_ID_USUARIO , FREELANCER_ID_USUARIO ) VALUES
        (false, 1, 2);


-- planejamento:  planner, figma, github, planejamento
-- ferramenta de ideação: lean ux, user stories, proto persona;



