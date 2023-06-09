--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1
-- Dumped by pg_dump version 15.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: clientes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clientes (
    cliente_id bigint NOT NULL,
    correo_cliente character varying(255) NOT NULL,
    direccion_cliente character varying(255) NOT NULL,
    cedula_ruc_cliente character varying(255) NOT NULL,
    nombre_cliente character varying(255) NOT NULL,
    telefono character varying(255)
);


ALTER TABLE public.clientes OWNER TO postgres;

--
-- Name: clientes_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.clientes_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.clientes_sequence OWNER TO postgres;

--
-- Name: detalles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.detalles (
    detalle_id bigint NOT NULL,
    cantidad numeric(19,2) NOT NULL,
    iva numeric(19,2) NOT NULL,
    precio numeric(19,2) NOT NULL,
    subtotal numeric(19,2) NOT NULL,
    unidad_medida character varying(255) NOT NULL,
    factura_id bigint,
    producto_id bigint
);


ALTER TABLE public.detalles OWNER TO postgres;

--
-- Name: detalles_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.detalles_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.detalles_sequence OWNER TO postgres;

--
-- Name: facturas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.facturas (
    factura_id bigint NOT NULL,
    establecimiento character varying(255),
    fecha_factura date,
    num_factura character varying(255),
    punto_emision character varying(255),
    subtotal numeric(19,2) NOT NULL,
    total numeric(19,2) NOT NULL,
    totaliva numeric(19,2) NOT NULL,
    cliente_id bigint
);


ALTER TABLE public.facturas OWNER TO postgres;

--
-- Name: facturas_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.facturas_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.facturas_sequence OWNER TO postgres;

--
-- Name: productos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.productos (
    producto_id bigint NOT NULL,
    categoria character varying(255) NOT NULL,
    codigo character varying(255) NOT NULL,
    descripcion text NOT NULL,
    nombre character varying(255) NOT NULL
);


ALTER TABLE public.productos OWNER TO postgres;

--
-- Name: productos_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.productos_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.productos_sequence OWNER TO postgres;

--
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
    role_id bigint NOT NULL,
    role_name character varying(255) NOT NULL
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- Name: roles_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.roles_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_sequence OWNER TO postgres;

--
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuarios (
    usuario_id bigint NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    role_id bigint
);


ALTER TABLE public.usuarios OWNER TO postgres;

--
-- Name: usuarios_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuarios_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuarios_sequence OWNER TO postgres;

--
-- Data for Name: clientes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.clientes (cliente_id, correo_cliente, direccion_cliente, cedula_ruc_cliente, nombre_cliente, telefono) FROM stdin;
1	cliente1@example.com	Gomez rendon #2016	0963312441	Daniel Puertas	0982023693
2	cliente2@example.com	Gomez rendon #2015	0963312551	Luis Lopez	0982028893
3	cliente3@example.com	Gomez rendon #2017	0963314441	Teresa Moron	0982023693
4	cliente4@example.com	Gomez rendon #2013	0863312441	Carlos Bravo	0982023693
\.


--
-- Data for Name: detalles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.detalles (detalle_id, cantidad, iva, precio, subtotal, unidad_medida, factura_id, producto_id) FROM stdin;
\.


--
-- Data for Name: facturas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.facturas (factura_id, establecimiento, fecha_factura, num_factura, punto_emision, subtotal, total, totaliva, cliente_id) FROM stdin;
\.


--
-- Data for Name: productos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.productos (producto_id, categoria, codigo, descripcion, nombre) FROM stdin;
1	hogar	a001	Renueva tu hogar con este juego de s├íbanas de algod├│n de alta calidad. Suavidad y comodidad garantizadas para un descanso reparador. Incluye s├íbana ajustable, s├íbana plana y fundas de almohada. Dale un toque de estilo a tu dormitorio con este conjunto imprescindible.	Juego de Sabanas
2	ropa	a002	Eleva tu estilo con esta blusa de seda estampada. Dise├▒o exclusivo y detalles delicados para un look ├║nico. Tejido de seda suave y ligero que te brinda lujo y comodidad. Ideal para ocasiones especiales o un toque de elegancia en tu d├¡a a d├¡a.	Blusa de Seda
3	juguetes	a003	Despierta la imaginaci├│n de tus hijos con este set de construcci├│n. Piezas coloridas y vers├ítiles para crear infinitas estructuras. Fomenta la creatividad y la destreza manual. Material seguro y resistente para horas de diversi├│n sin preocupaciones.	Set de Construccion
4	alimentos	a004	Disfruta de este delicioso chocolate con leche. Su sabor exquisito y textura cremosa te deleitar├ín en cada bocado. Ideal para satisfacer tus antojos y compartir momentos dulces con tus seres queridos.	Lampara de Mesa
5	hogar	a005	Ilumina tu sala de estar con estas modernas l├ímparas de mesa. Combina estilo y funcionalidad para crear un ambiente acogedor. Dise├▒o elegante con base de metal resistente y pantalla de tela suave. Un complemento ideal para cualquier decoraci├│n.	Abrigo de Lana
6	ropa	a006	Actualiza tu armario con este abrigo de lana para mujer. Dise├▒o cl├ísico y atemporal para enfrentar el fr├¡o con estilo. Corte elegante que resalta tu figura y tejido de lana para abrigarte en los d├¡as m├ís fr├¡os. Una prenda vers├ítil para lucir sofisticada en cualquier ocasi├│n.	Peluche Interactivo
7	juguetes	a007	Sorprende a tus hijos con este adorable peluche interactivo. Suave y mimoso compa├▒ero que habla, canta y baila. Sensor t├íctil para reaccionar a las caricias. Proporciona horas de entretenimiento y se convertir├í en su mejor amigo.	Cereal con Frutas
8	alimentos	a008	Prueba este nutritivo cereal de avena con frutas. Desayuno saludable y delicioso que te brinda energ├¡a para comenzar el d├¡a. Mezcla de sabores y texturas para una experiencia ├║nica. Cuida tu alimentaci├│n sin sacrificar el sabor.	Juego de Construccion
9	juguetes	a009	Despierta la creatividad y la diversi├│n con este emocionante juego de construcci├│n. Crea tus propios robots, naves espaciales y criaturas fant├ísticas con las piezas modulares. Desaf├¡a tu ingenio y desarrolla habilidades STEM mientras exploras un mundo de posibilidades. ┬íDeja volar tu imaginaci├│n y divi├®rtete construyendo aventuras sin l├¡mites!	Juego de Construccion para adultos
10	ropa	a010	Expresa tu estilo con esta elegante chaqueta de cuero. Dise├▒ada con atenci├│n a los detalles y fabricada con materiales de alta calidad, esta chaqueta te brinda un look sofisticado y a la moda. Comb├¡nala con jeans o una falda para lucir impresionante en cualquier ocasi├│n. ┬íDestaca entre la multitud con esta prenda ├║nica!	Chaqueta de Cuero
\.


--
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.roles (role_id, role_name) FROM stdin;
1	Administrador
2	Supervisor
3	Vendedor
\.


--
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuarios (usuario_id, email, password, role_id) FROM stdin;
1	user1@example.com	password1	1
2	user2@example.com	password2	2
3	user3@example.com	password3	3
\.


--
-- Name: clientes_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.clientes_sequence', 4, true);


--
-- Name: detalles_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.detalles_sequence', 1, false);


--
-- Name: facturas_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.facturas_sequence', 1, false);


--
-- Name: productos_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.productos_sequence', 10, true);


--
-- Name: roles_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.roles_sequence', 3, true);


--
-- Name: usuarios_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuarios_sequence', 3, true);


--
-- Name: clientes clientes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (cliente_id);


--
-- Name: detalles detalles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalles
    ADD CONSTRAINT detalles_pkey PRIMARY KEY (detalle_id);


--
-- Name: facturas facturas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.facturas
    ADD CONSTRAINT facturas_pkey PRIMARY KEY (factura_id);


--
-- Name: productos productos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productos
    ADD CONSTRAINT productos_pkey PRIMARY KEY (producto_id);


--
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (role_id);


--
-- Name: roles uk_716hgxp60ym1lifrdgp67xt5k; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT uk_716hgxp60ym1lifrdgp67xt5k UNIQUE (role_name);


--
-- Name: clientes uk_9ijsuuqg6lnln6bnw7fqdmjvs; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT uk_9ijsuuqg6lnln6bnw7fqdmjvs UNIQUE (correo_cliente);


--
-- Name: clientes uk_cqi930fg93kcfvuu4ye1xg6lt; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT uk_cqi930fg93kcfvuu4ye1xg6lt UNIQUE (direccion_cliente);


--
-- Name: facturas uk_fu79ndupfc6q3g7o9xd1dq48i; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.facturas
    ADD CONSTRAINT uk_fu79ndupfc6q3g7o9xd1dq48i UNIQUE (num_factura);


--
-- Name: productos uk_h04wpyqwddobltuqq56cp6s05; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productos
    ADD CONSTRAINT uk_h04wpyqwddobltuqq56cp6s05 UNIQUE (codigo);


--
-- Name: clientes uk_k6lx8x0jl4hlw2b62pv7i0ma; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT uk_k6lx8x0jl4hlw2b62pv7i0ma UNIQUE (cedula_ruc_cliente);


--
-- Name: usuarios uk_kfsp0s1tflm1cwlj8idhqsad0; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT uk_kfsp0s1tflm1cwlj8idhqsad0 UNIQUE (email);


--
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (usuario_id);


--
-- Name: facturas fk1qiuk10rfkovhlfpsk7oic0v8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.facturas
    ADD CONSTRAINT fk1qiuk10rfkovhlfpsk7oic0v8 FOREIGN KEY (cliente_id) REFERENCES public.clientes(cliente_id);


--
-- Name: usuarios fkeljjw3mx8n5ngoe7fbqbjwusp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT fkeljjw3mx8n5ngoe7fbqbjwusp FOREIGN KEY (role_id) REFERENCES public.roles(role_id);


--
-- Name: detalles fkio4oyl8qt5jclekxp7bwws2iy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalles
    ADD CONSTRAINT fkio4oyl8qt5jclekxp7bwws2iy FOREIGN KEY (producto_id) REFERENCES public.productos(producto_id);


--
-- Name: detalles fkp8gc543ugpvdux29nhe2uguo6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalles
    ADD CONSTRAINT fkp8gc543ugpvdux29nhe2uguo6 FOREIGN KEY (factura_id) REFERENCES public.facturas(factura_id);


--
-- PostgreSQL database dump complete
--

