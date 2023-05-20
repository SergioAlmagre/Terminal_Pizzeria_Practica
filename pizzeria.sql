-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-05-2023 a las 17:58:33
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pizzeria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `dni` varchar(15) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `observaciones` varchar(245) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`nombre`, `apellido`, `dni`, `telefono`, `direccion`, `observaciones`) VALUES
('Miguel', 'Sánchez', '11785439I', '651893292', 'Calle de las Flores, 2', 'Con alergia a los frutos secos'),
('Sofía', 'Álvarez', '1269543B', '696316676', 'Avenida del Mar, 25', 'Cliente nuevo'),
('Sofía', 'Romero', '13620966C', '650741236', 'Calle del Sol, 17', 'Cliente nuevo'),
('María', 'Álvarez', '14698772C', '653152570', 'Plaza España, 8', 'Vegano'),
('Laura', 'López', '14708039H', '673572919', 'Paseo de la Castellana, 50', 'Pedido grande'),
('María', 'Rodríguez', '16067990G', '646116230', 'Calle de las Flores, 2', 'Pedido especial'),
('Ana', 'Fernández', '16351979I', '692403676', 'Calle de las Flores, 2', 'Sin lactosa'),
('Pedro', 'Rodríguez', '16626183G', '671717707', 'Avenida del Mar, 25', 'Sin gluten'),
('María', 'González', '16664908F', '636977428', 'Callejón de los Suspiros, 5', 'Con alergia a los frutos secos'),
('Pedro', 'Álvarez', '1734455H', '852369741', 'Calle Mayor, 10', 'Pedido especial'),
('Carlos', 'Romero', '19481880D', '638826492', 'Callejón del Gato, 13', 'Pedido especial'),
('Miguel', 'González', '21270945A', '684822853', 'Callejón del Gato, 13', 'Sin gluten'),
('Sofía', 'Martínez', '21671527G', '627087269', 'Calle Mayor, 10', 'Vegano'),
('Laura', 'Rodríguez', '2176267A', '609168188', 'Calle Mayor, 10', 'Pendiente de pago'),
('Sofía', 'Álvarez', '2243117I', '610999934', 'Paseo del Prado, 20', 'Pendiente de pago'),
('Miguel', 'Sánchez', '22897717H', '665202102', 'Paseo del Prado, 20', 'Cliente nuevo'),
('Lucía', 'González', '23390024H', '622202114', 'Plaza España, 8', 'Cliente nuevo'),
('Sofía', 'Rodríguez', '24665703A', '670077282', 'Callejón del Gato, 13', 'Vegano'),
('Carlos', 'González', '25180948E', '622786714', 'Avenida del Mar, 25', 'Pedido grande'),
('Carlos', 'Romero', '28883299D', '693690679', 'Paseo del Prado, 20', 'Sin gluten'),
('Laura', 'Sánchez', '31574942A', '646736737', 'Callejón de los Suspiros, 5', 'Pedido grande'),
('Ana', 'Álvarez', '32543599B', '672857796', 'Calle Mayor, 10', 'Cliente nuevo'),
('María', 'López', '36225617B', '852369741', 'Plaza España, 8', 'Vegano'),
('Sofía', 'Pérez', '36267324C', '672758498', 'Plaza España, 8', 'Pedido grande'),
('Juan', 'Fernández', '37874986F', '692001037', 'Paseo del Prado, 20', 'Vegetariano'),
('Ana', 'Fernández', '42147133I', '668168034', 'Plaza España, 8', 'Pendiente de pago'),
('Juan', 'López', '43478200F', '614680278', 'Avenida del Mar, 25', 'Cliente habitual'),
('Laura', 'García', '45678901D', '456123789', 'Calle del Agua, 7', 'Sin lactosa'),
('Lucía', 'Fernández', '45965136C', '661321468', 'Plaza España, 8', 'Vegano'),
('Pedro', 'López', '48304879I', '655516606', 'Paseo del Prado, 20', 'Vegano'),
('Luis', 'Sánchez', '50159338F', '676928913', 'Plaza España, 8', 'Con alergia a los frutos secos'),
('Lucía', 'López', '50835916G', '621540945', 'Callejón de los Suspiros, 5', 'Sin lactosa'),
('Pedro', 'Rodríguez', '55982374E', '623398267', 'Callejón de los Suspiros, 5', 'Vegetariano'),
('Miguel', 'Álvarez', '57453735B', '646211574', 'Callejón de los Suspiros, 5', 'Sin lactosa'),
('Carlos', 'López', '58096808C', '691826429', 'Calle de las Flores, 2', 'Cliente habitual'),
('Ana', 'Fernández', '60548366H', '605095679', 'Calle del Sol, 17', 'Cliente nuevo'),
('Luis', 'González', '61953990G', '672294920', 'Paseo de la Castellana, 50', 'Sin gluten'),
('Laura', 'Romero', '62984657H', '659453370', 'Callejón de los Suspiros, 5', 'Pedido grande'),
('Ana', 'Pérez', '63165490C', '680953294', 'Calle del Sol, 17', 'Pendiente de pago'),
('Ana', 'Fernández', '63188040A', '646354060', 'Callejón del Gato, 13', 'Cliente habitual'),
('Juan', 'Álvarez', '64003774E', '612016279', 'Calle del Sol, 17', 'Pendiente de pago'),
('Lucía', 'Martínez', '67890123F', '159263487', 'Calle del Agua, 7', 'Vegano'),
('Juan', 'Rodríguez', '67960393C', '654238054', 'Avenida del Mar, 25', 'Pendiente de pago'),
('María', 'Sánchez', '68328235I', '617950829', 'Avenida del Mar, 25', 'Pendiente de pago'),
('Carlos', 'López', '68902506F', '693924871', 'Callejón de los Suspiros, 5', 'Con alergia a los frutos secos'),
('Miguel', 'Álvarez', '69023922G', '658767972', 'Callejón del Gato, 13', 'Sin lactosa'),
('Miguel', 'González', '70400047I', '649845722', 'Paseo de la Castellana, 50', 'Sin gluten'),
('Lucía', 'Romero', '73054133H', '699461550', 'Calle del Agua, 7', 'Pendiente de pago'),
('Laura', 'García', '76726029B', '606864549', 'Callejón de los Suspiros, 5', 'Cliente nuevo'),
('Lucía', 'Pérez', '78901234G', '753951468', 'Calle de las Flores, 2', 'Pendiente de pago'),
('Lucía', 'Martínez', '81201521D', '636835076', 'Callejón de los Suspiros, 5', 'Cliente nuevo'),
('Miguel', 'Romero', '83210911B', '688354038', 'Calle del Agua, 7', 'Cliente habitual'),
('Lucía', 'Romero', '85495058A', '634235451', 'Plaza España, 8', 'Con alergia a los frutos secos'),
('Ana', 'Martínez', '8767623D', '647984681', 'Plaza España, 8', 'Cliente habitual'),
('Juan', 'Romero', '89012345H', '123456789', 'Plaza España, 8', 'Vegetariano'),
('Carlos', 'Rodríguez', '90123456I', '159263487', 'Calle del Agua, 7', 'Pendiente de pago'),
('Ana', 'Álvarez', '91353699D', '651718724', 'Plaza España, 8', 'Pendiente de pago'),
('Carlos', 'Martínez', '93483154I', '607545614', 'Plaza España, 8', 'Pedido especial'),
('Juan', 'González', '95291292D', '653308458', 'Paseo de la Castellana, 50', 'Cliente nuevo'),
('Laura', 'López', '96679159G', '600097711', 'Plaza España, 8', 'Con alergia a los frutos secos'),
('Pedro', 'García', '97790880A', '642646940', 'Paseo de la Castellana, 50', 'Pedido especial'),
('Sofía', 'Martínez', '9854211G', '678128367', 'Calle del Agua, 7', 'Cliente nuevo'),
('Rodrigo', 'Alcampo', '999888777', '85241778Q', 'C/BurguerKing', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `telefono` varchar(30) NOT NULL,
  `dni` varchar(10) NOT NULL,
  `contraseña` varchar(30) NOT NULL,
  `tipo` int(1) NOT NULL,
  `observaciones` varchar(240) NOT NULL,
  `rutafoto` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`nombre`, `apellido`, `telefono`, `dni`, `contraseña`, `tipo`, `observaciones`, `rutafoto`) VALUES
('Lucía', 'Fernández', '623456789', '23387263', '1234', 0, 'Buen vendedor', '8'),
('Ana', 'Sánchez', '699876543', '26656046', '1234', 0, 'Habla varios idiomas', '7'),
('Luis', 'Rodríguez', '688765432', '29210551', '1234', 1, 'Habla varios idiomas', '5'),
('Pedro', 'Jiménez', '679401777', '30453861', '1234', 1, 'Cliente habitual', '6'),
('María', 'Rodríguez', '634567890', '30810468', '1234', 0, 'Habla varios idiomas', '3'),
('Pablo', 'Alonso', '698525784', '31267770', '1234', 1, 'Siempre llega tarde', '2'),
('Miguel', 'Jiménez', '677654321', '38001911', '1234', 1, 'Habla varios idiomas', '4'),
('Lucía', 'Pérez', '678123456', '38033661', '1234', 1, 'Habla varios idiomas', '6'),
('María', 'Pérez', '684733498', '38265736', '1234', 1, 'Cliente habitual', '2'),
('Pablo', 'Fernández', '612345678', '39862255', '1234', 0, 'Cliente habitual', '8'),
('Estefania', 'García', '645678901', '54987654', '1234', 0, 'Habla varios idiomas', '4'),
('Lucía', 'Gutiérrez', '676417573', '55413979', '1234', 0, 'Habla varios idiomas', '2'),
('Luis', 'Jiménez', '612345678', '55830542', '1234', 0, 'Habla varios idiomas', '4'),
('Pablo', 'García', '678123456', '57190344', '1234', 1, 'Buen vendedor', '6'),
('Laura', 'Sánchez', '602950536', '58266650', '1234', 0, 'Cliente habitual', '1'),
('Miguel', 'Rodríguez', '639202990', '61336504', '1234', 0, 'Buen vendedor', '2'),
('Jorge', 'Rodríguez', '612345678', '65480203', '1234', 1, 'Cliente habitual', '6'),
('Luis', 'Rodríguez', '668627806', '66532306', '1234', 0, 'Buen vendedor', '5'),
('Juan', 'Alonso', '624674140', '68013970', '1234', 1, 'Siempre llega tarde', '6'),
('Laura', 'Gutiérrez', '634567890', '71216336', '1234', 0, 'Habla varios idiomas', '9'),
('María', 'Gutiérrez', '643195103', '80610366', '1234', 1, 'Buen vendedor', '9'),
('Miguel', 'Pérez', '622345678', '81342683', '1234', 0, 'Buen vendedor', '2'),
('Laura', 'Pérez', '699876543', '84569786', '1234', 0, 'Cliente habitual', '5'),
('Laura', 'García', '678123456', '89362509', '1234', 1, 'Buen vendedor', '9'),
('Miguel', 'Alonso', '634567890', '94091601', '1234', 1, 'Muy puntual', '2'),
('Ana', 'Sánchez', '676762480', '97234594', '1234', 0, 'Cliente habitual', '2'),
('Laura', 'Gutiérrez', '646671979', 'admin', '1234', 1, 'Muy puntual', '8'),
('Luis', 'Rodríguez', '678123456', 'emple', '1234', 0, 'Cliente habitual', '8');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingrediente`
--

CREATE TABLE `ingrediente` (
  `tipo` int(1) NOT NULL,
  `nombre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ingrediente`
--

INSERT INTO `ingrediente` (`tipo`, `nombre`) VALUES
(0, 'harina'),
(1, 'queso'),
(2, 'tomate'),
(3, 'oregano'),
(4, 'pollo'),
(5, 'piña'),
(6, 'nata'),
(7, 'bacon'),
(8, 'york'),
(9, 'huevo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `numeropedido` int(7) NOT NULL,
  `fecha` varchar(30) NOT NULL,
  `tiempoespera` double(6,2) NOT NULL,
  `atendidoenlocal` int(1) NOT NULL,
  `mesa` int(1) NOT NULL,
  `idpizza` int(11) NOT NULL,
  `telefonocliente` varchar(20) NOT NULL,
  `hora` varchar(30) NOT NULL,
  `preciototal` double(6,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`numeropedido`, `fecha`, `tiempoespera`, `atendidoenlocal`, `mesa`, `idpizza`, `telefonocliente`, `hora`, `preciototal`) VALUES
(48, '2023-05-14', 20.00, 0, 5, 86, '653152570', '17:09:05.9', 12.50),
(49, '2023-05-14', 20.00, 0, 3, 87, '673572919', '17:09:05.9', 13.60),
(50, '2023-05-14', 20.00, 0, 4, 88, '696316676', '17:16:37.4', 11.50),
(51, '2023-05-14', 20.00, 0, 4, 89, '696316676', '17:16:37.4', 11.50),
(52, '2023-05-14', 20.00, 0, 4, 90, '650741236', '17:16:37.4', 11.50),
(53, '2023-05-14', 20.00, 0, 4, 91, '684822853', '17:27:13.4', 12.50),
(54, '2023-05-14', 20.00, 1, 0, 92, '659453370', '17:57:06.1', 12.50);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pizza`
--

CREATE TABLE `pizza` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `precio` double NOT NULL,
  `tamaño` int(1) NOT NULL,
  `especial` int(1) NOT NULL,
  `ingrextra` int(1) DEFAULT NULL,
  `hora` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pizza`
--

INSERT INTO `pizza` (`id`, `nombre`, `precio`, `tamaño`, `especial`, `ingrextra`, `hora`) VALUES
(1, 'Marinera', 14.39, 1, 1, 0, '19:12:17.356365200'),
(2, 'Carbonara', 12.5, 1, 2, 2, '19:16:10.725516200'),
(3, 'Marinera', 11.5, 1, 1, 0, '19:30:34.277418100'),
(4, 'Carbonara', 12.5, -1, 1, 3, '19:32:03.175062900'),
(5, 'Carbonara', 12.5, 1, 2, 0, '19:07:37.265797300'),
(6, 'Carbonara', 12.5, 1, 1, 0, '02:49:30.085470200'),
(7, 'Marinera', 11.5, 1, 2, 3, '02:57:59.271982700'),
(8, 'Carbonara', 12.5, 1, 1, 3, '03:10:29.908663100'),
(9, '', 13.5, 1, 1, 0, '03:12:36.006268700'),
(10, '', 15.3, 2, 1, 4, '03:15:48.100815200'),
(11, '', 15.3, 2, 1, 4, '03:15:48.100815200'),
(12, '', 15.3, 2, 1, 4, '03:15:48.100815200'),
(13, '', 15.3, 2, 1, 4, '03:15:48.100815200'),
(14, 'Carbonara', 12.5, 1, 2, 3, '03:18:44.398357700'),
(15, 'Especial de la casa', 14.5, 1, 3, 0, '03:23:52.557590400'),
(16, 'Especial de la casa', 14.5, 2, 3, 4, '03:24:31.224920300'),
(17, 'Especial de la casa', 14.5, 1, 3, 4, '03:25:11.009965800'),
(18, 'Queso', 10.5, 1, 2, 0, '03:25:57.193311900'),
(19, 'Carbonara', 12.5, 1, 2, 0, '03:29:53.053688500'),
(20, 'Carbonara', 12.5, 0, 1, 3, '03:31:01.730913400'),
(21, 'Especial de la casa', 14.5, 1, 3, 4, '03:35:26.470074'),
(22, 'Especial de la casa', 14.5, 1, 3, 4, '03:37:29.812818'),
(23, 'Carbonara', 12.5, 1, 2, 0, '03:38:42.900593700'),
(24, 'Carbonara', 12.5, 2, 2, 0, '03:40:35.815139200'),
(25, '', 13.5, 2, 2, 3, '03:43:01.683071600'),
(26, '', 13.5, 1, 3, 3, '03:45:11.710754900'),
(27, 'Especial de la casa', 14.5, 2, 2, 2, '03:46:33.962888400'),
(28, 'Marinera', 11.5, 2, 0, 3, '03:46:33.962888400'),
(29, 'Especial de la casa', 14.5, 2, 3, 4, '03:48:13.235252'),
(30, 'Marinera', 11.5, 1, 3, 2, '03:48:13.235252'),
(31, '', 13.5, 1, 2, 4, '03:48:55.341570500'),
(32, 'Marinera', 11.5, 2, 1, 2, '03:50:18.668104500'),
(33, 'Carbonara', 12.5, 1, 2, 0, '04:00:00.573824100'),
(34, 'Marinera', 11.5, 1, 1, 2, '04:00:47.967445400'),
(35, 'Carbonara', 12.5, 2, 2, 0, '04:01:47.476406800'),
(36, 'Carbonara', 12.5, 1, 2, 2, '04:04:56.168644600'),
(37, 'Queso', 10.5, 2, 0, 0, '04:06:31.957438100'),
(38, 'Carbonara', 14.6, -1, 2, 2, '04:08:26.547338200'),
(39, 'Especial de la casa', 14.5, -1, 3, 4, '04:09:10.306870'),
(40, 'Especial de la casa', 14.5, -1, 1, 2, '04:13:26.340948500'),
(41, 'Queso', 10.5, 1, 0, 0, '04:18:56.112524400'),
(42, 'Especial de la casa', 14.5, 2, 1, 2, '04:21:13.025584100'),
(43, 'Marinera', 11.5, 1, 2, 3, '10:42:46.141994400'),
(44, 'Marinera', 11.5, 1, 2, 3, '10:42:46.141994400'),
(45, 'Marinera', 11.5, 2, 0, 3, '10:46:37.699143600'),
(46, 'Marinera', 11.5, 2, 0, 3, '10:46:37.699143600'),
(47, 'Marinera', 11.5, 1, 0, 3, '10:46:37.699143600'),
(48, 'Tropical', 10.5, 1, 2, 3, '10:49:27.233162100'),
(49, 'Especial de la casa', 14.5, 1, 3, 4, '10:51:46.712108700'),
(50, '', 13.5, 2, 2, 2, '10:55:11.585514'),
(51, '', 15.6, 1, 0, 2, '10:59:41.973034300'),
(52, 'Marinera', 11.5, -1, 2, 0, '11:01:30.740946100'),
(53, '', 0, -1, 0, 0, '11:08:42.981196'),
(54, 'Tropical', 10.5, -1, 0, 0, '11:08:42.981196'),
(55, 'Queso', 13.8, -1, 0, 0, '11:08:42.981196'),
(56, 'Tropical', 12.3, -1, 0, 4, '11:08:42.981196'),
(57, 'Tropical', 14.4, -1, 0, 3, '11:08:42.981196'),
(58, 'Especial de la casa', 14.5, -1, 0, 3, '11:08:42.981196'),
(59, 'Especial de la casa', 14.5, -1, 0, 3, '11:08:42.981196'),
(60, '', 0, -1, 0, 0, '11:19:28.682785200'),
(61, 'Marinera', 11.5, 2, 0, 0, '11:23:50.940035600'),
(62, 'Carbonara', 12.5, 1, -1, 0, '13:18:03.330423200'),
(63, 'Carbonara', 15.39, 0, 1, 0, '13:28:55.986246400'),
(64, 'Carbonara', 12.5, 0, 0, 0, '13:33:06.066403500'),
(65, 'Carbonara', 12.5, 1, 1, 0, '13:33:51.029513100'),
(66, 'Especial de la casa', 16.3, 0, 2, 3, '13:37:12.676140200'),
(67, 'Especial de la casa', 16.3, 1, 2, 3, '13:41:40.085633700'),
(68, 'Especial de la casa', 14.5, 2, 1, 2, '13:51:11.778112'),
(69, 'Especial de la casa', 14.5, 1, 0, 0, '13:52:53.539894400'),
(70, 'Carbonara', 12.5, 1, 0, 0, '13:52:53.539894400'),
(71, 'Marinera', 11.5, 0, 0, 0, '13:55:40.039799600'),
(72, 'Marinera', 11.5, 0, 0, 0, '13:55:40.039799600'),
(73, 'Carbonara', 12.5, 0, 0, 0, '13:57:35.866931800'),
(74, 'Especial de la casa', 14.5, 1, 0, 2, '13:57:35.866931800'),
(75, 'Marinera', 11.5, 1, 1, 2, '14:06:40'),
(76, 'Marinera', 11.5, 0, 0, 1, '14:08:30'),
(77, 'Especial de la casa', 14.5, 0, 0, 0, '14:19:10.'),
(78, 'Especial de la casa', 14.5, 0, 0, 0, '14:21:51.0'),
(79, 'Especial de la casa', 14.5, 0, 2, 3, '14:24:19.9'),
(80, 'Queso', 10.5, 0, -1, -1, '14:25:31.4'),
(81, 'Marinera', 11.5, 1, 0, 1, '14:41:52.0'),
(82, 'Carbonara', 12.5, 0, 1, 2, '15:11:18.9'),
(83, 'Carbonara', 12.5, 2, 1, 2, '15:13:37.9'),
(84, 'Especial de la casa', 14.5, 0, 2, 3, '15:15:07.8'),
(85, 'Queso', 11.5, 0, 0, -1, '15:17:02.6'),
(86, 'Carbonara', 12.5, 1, 0, 0, '17:09:05.9'),
(87, 'Marinera', 13.6, 2, -1, 1, '17:09:05.9'),
(88, 'Marinera', 11.5, 1, 0, 0, '17:16:37.4'),
(89, 'Marinera', 11.5, 1, 0, 0, '17:16:37.4'),
(90, 'Marinera', 11.5, 1, 0, 0, '17:16:37.4'),
(91, 'Carbonara', 12.5, 1, -1, 2, '17:27:13.4'),
(92, 'Carbonara', 12.5, 1, 1, 0, '17:57:06.1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pizzatieneingrediente`
--

CREATE TABLE `pizzatieneingrediente` (
  `tipoIngrediente` int(1) NOT NULL,
  `idpizza` int(1) NOT NULL,
  `cantidadingrediente` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pizzeria`
--

CREATE TABLE `pizzeria` (
  `id` int(11) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `telefono` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pizzeria`
--

INSERT INTO `pizzeria` (`id`, `direccion`, `telefono`) VALUES
(1, '88 Queensway, Admiralty, Hong Kong', '9268844561');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pizzeriaturno`
--

CREATE TABLE `pizzeriaturno` (
  `idpizzeria` int(2) NOT NULL,
  `fecha` varchar(30) NOT NULL,
  `turno` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turno`
--

CREATE TABLE `turno` (
  `tipoturno` int(1) NOT NULL,
  `dniempleado` varchar(10) NOT NULL,
  `fecha` varchar(20) NOT NULL,
  `nombreturno` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`dni`,`telefono`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `ingrediente`
--
ALTER TABLE `ingrediente`
  ADD PRIMARY KEY (`tipo`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`numeropedido`,`telefonocliente`),
  ADD KEY `idpizza` (`idpizza`);

--
-- Indices de la tabla `pizza`
--
ALTER TABLE `pizza`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pizzatieneingrediente`
--
ALTER TABLE `pizzatieneingrediente`
  ADD PRIMARY KEY (`tipoIngrediente`,`idpizza`),
  ADD KEY `idpizza` (`idpizza`);

--
-- Indices de la tabla `pizzeria`
--
ALTER TABLE `pizzeria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pizzeriaturno`
--
ALTER TABLE `pizzeriaturno`
  ADD PRIMARY KEY (`fecha`,`turno`,`idpizzeria`),
  ADD KEY `idpizzeria` (`idpizzeria`),
  ADD KEY `turno` (`turno`);

--
-- Indices de la tabla `turno`
--
ALTER TABLE `turno`
  ADD PRIMARY KEY (`tipoturno`,`fecha`),
  ADD KEY `dniempleado` (`dniempleado`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `numeropedido` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT de la tabla `pizza`
--
ALTER TABLE `pizza`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=93;

--
-- AUTO_INCREMENT de la tabla `pizzeria`
--
ALTER TABLE `pizzeria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`idpizza`) REFERENCES `pizza` (`id`);

--
-- Filtros para la tabla `pizzatieneingrediente`
--
ALTER TABLE `pizzatieneingrediente`
  ADD CONSTRAINT `pizzatieneingrediente_ibfk_1` FOREIGN KEY (`idpizza`) REFERENCES `pizza` (`id`),
  ADD CONSTRAINT `pizzatieneingrediente_ibfk_2` FOREIGN KEY (`tipoIngrediente`) REFERENCES `ingrediente` (`tipo`);

--
-- Filtros para la tabla `pizzeriaturno`
--
ALTER TABLE `pizzeriaturno`
  ADD CONSTRAINT `pizzeriaturno_ibfk_1` FOREIGN KEY (`idpizzeria`) REFERENCES `pizzeria` (`id`),
  ADD CONSTRAINT `pizzeriaturno_ibfk_2` FOREIGN KEY (`turno`) REFERENCES `turno` (`tipoturno`);

--
-- Filtros para la tabla `turno`
--
ALTER TABLE `turno`
  ADD CONSTRAINT `turno_ibfk_1` FOREIGN KEY (`dniempleado`) REFERENCES `empleado` (`dni`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
