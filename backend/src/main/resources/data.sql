		INSERT INTO TB_USERS (NOME, EMAIL, SENHA, CELULAR, SOBRE, IS_LOGGED) VALUES
		('Ana',
		 'anarodrigues@gmail.com',
		 '123',
		 '11980994139',
		 'Olá, eu sou Ana! Atuo como web designer e estrategista digital, especializada em criação de sites dinâmicos e responsivos, focado em converter, atrair clientes e construir autoridade para sua marca. Esta área de web design com a qual me identifico e busco crescimento constante.Tenho conhecimento em WordPress e recentemente criei sites para empresas com a qual divulgaram no Google ADS e obtiveram ótimos resultados em prospecção de clientes e execução de serviços.',
		  0
		 );

        INSERT INTO TB_FREELANCER (ID_USUARIO) VALUES
        (3);

        INSERT INTO TB_ENDERECO (CIDADE, ESTADO, id_usuario) VALUES
        ('Ribeirão Pires', 'SP', 2),


		INSERT INTO TB_USERS_ROLES (ID_ROLE, ID_USUARIO) VALUES
		(2, 1),(3,2);

		INSERT INTO TB_SOCIAL (NOME) VALUES
        ('Facebook'),('Instagram'),('Linkedin');


		INSERT INTO TB_HABILIDADE (NOME) VALUES
		('FIGMA'),('Premier'),('Photoshop'),('Inkscape'),('Illustrator');

        INSERT INTO TB_ROLE (ROLE_NAME) VALUES
        ('ROLE_ADMIN'),('ROLE_CONTRATANTE'),('ROLE_FREELANCER');

		INSERT INTO TB_CONTRATANTE (ID_USUARIO) VALUES
        (1);

		INSERT INTO TB_SOCIAL_USER (USER_URL, ID_SOCIAL, ID_USUARIO) VALUES
		('GUILHEMRE.FACEBOOK', 1, 1),
        ('Vinicius.facebook', 1, 2);


		INSERT INTO TB_MATCH  (STATUS , CONTRATANTE_ID_USUARIO , FREELANCER_ID_USUARIO ) VALUES
        (0, 1, 2);




