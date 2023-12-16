CREATE TABLE IF NOT EXISTS public."OrdersList"
(
    "orderID" serial PRIMARY KEY,
    "dataCreated" character varying(255) COLLATE pg_catalog."default",
    status character varying(255) COLLATE pg_catalog."default",
    "customerID" integer,
    "employeeID" integer
    );
