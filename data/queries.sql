--- Retrieve Product Insights
SELECT pi.id AS insight_id,
       pc.name AS product_cluster,
       t.type AS trigger_type,
       pi.insight
FROM product_insights pi
JOIN product_clusters pc ON pi.product_cluster_id = pc.id
JOIN triggers t ON pi.trigger_id = t.id;

-- Retrieve Customer Experiences
SELECT ce.id AS experience_id,
       c.name AS customer_name,
       n.type AS need_type,
       m.type AS mission_type,
       tp.type AS touchpoint_type,
       jp.phase AS journey_phase,
       pp.type AS place_of_purchase
FROM customer_experiences ce
JOIN customers c ON ce.customer_id = c.id
JOIN needs n ON ce.need_id = n.id
JOIN missions m ON ce.mission_id = m.id
JOIN touchpoints tp ON ce.touchpoint_id = tp.id
JOIN journey_phases jp ON ce.journey_phase_id = jp.id
JOIN places_of_purchase pp ON ce.place_of_purchase_id = pp.id;

--- Retrieve Customer Experience Insights
SELECT cei.id AS insight_id,
       ce.id AS experience_id,
       cei.title AS title,
       cei.description AS description
FROM customer_experience_insights cei
JOIN customer_experiences ce ON cei.customer_experience_id = ce.id
GROUP BY cei.id, ce.id, cei.title, cei.description;