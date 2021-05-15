create database if not exists product_management_jpa;
use product_management_jpa;

select * from orders o
left join products_orders po on o.order_id = po.order_id
left join products p on po.product_id = p.product_id;