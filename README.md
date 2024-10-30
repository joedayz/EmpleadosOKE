# EmpleadosOKE
Demo using OKE with MySQL



INSERT INTO empleados (nombre, puesto, salario) VALUES
('Juan', 'Ingeniero', 70000),
('Ana', 'Gerente', 85000);

CREATE TABLE empleados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    puesto VARCHAR(50),
    salario DECIMAL(10, 2)
);
