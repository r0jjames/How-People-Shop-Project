-- Retrieve Customer Experiences
SELECT ce.id, c.name AS customer_name, n.type AS need_type, m.type AS mission_type,
       t.type AS touchpoint_type, jp.phase AS journey_phase, pp.type AS place_of_purchase_type
FROM customer_experiences ce
JOIN customers c ON ce.customer_id = c.id
JOIN needs n ON ce.need_id = n.id
JOIN missions m ON ce.mission_id = m.id
JOIN touchpoints t ON ce.touchpoint_id = t.id
JOIN journey_phases jp ON ce.journey_phase_id = jp.id
JOIN places_of_purchase pp ON ce.place_of_purchase_id = pp.id;
-- Retrieve Product Insights

SELECT pi.id, pc.name AS product_cluster_name, t.type AS trigger_type, pi.insight
FROM product_insights pi
JOIN product_clusters pc ON pi.product_cluster_id = pc.id
JOIN triggers t ON pi.trigger_id = t.id;
