INSERT INTO `workshop`.`customers` (`id`, `name`, `surname`, `phone`, `email`, `gender`, `comment`)
VALUES 
  ('1', 'Juan', 'Pérez', '555-1234', 'juan@example.com', '1', 'Cliente frecuente'),
  ('2', 'María', 'García', '555-5678', 'maria@example.com', '2', 'Nuevo cliente'),
  ('3', 'Carlos', 'Rodríguez', '555-9876', 'carlos@example.com', '1', 'Interesado en promociones'),
  ('4', 'Laura', 'Sánchez', '555-4321', 'laura@example.com', '2', 'Consulta sobre productos'),
  ('5', 'Alejandro', 'López', '555-8765', 'alejandro@example.com', '1', 'Solicita información');

INSERT INTO `workshop`.`motorcycles` (`id`, `domain`, `brand`, `kilometers`, `chassis`, `motor_number`, `model`, `cylinder`, `year`, `comment`)
VALUES 
  ('1', 'ABC123', 'Honda', '5000', 'CH123456', 'M123456789', 'CBR500R', '500', '2022', 'Servicio de rutina'),
  ('2', 'XYZ789', 'Yamaha', '3000', 'CH789012', 'M987654321', 'YZF-R6', '600', '2021', 'Cambio de aceite programado'),
  ('3', 'DEF456', 'Kawasaki', '8000', 'CH345678', 'M567890123', 'Ninja 650', '650', '2020', 'Reparación de frenos'),
  ('4', 'GHI789', 'Suzuki', '12000', 'CH901234', 'M234567890', 'GSX-R750', '750', '2019', 'Inspección de neumáticos'),
  ('5', 'JKL012', 'Ducati', '6000', 'CH567890', 'M345678901', 'Monster 821', '821', '2018', 'Ajuste de la cadena de transmisión');
