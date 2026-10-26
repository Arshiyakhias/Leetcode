# Write your MySQL query statement below

select sample_id,dna_sequence, species, 

CASE 
    WHEN dna_sequence LIKE 'ATG%'  THEN 1
    ELSE 0
END AS has_start,

CASE 
    WHEN dna_sequence LIKE '%TAA' OR dna_sequence LIKE '%TAG' OR dna_sequence LIKE '%TGA' THEN 1
    ELSE 0
END AS has_stop,

CASE 
    WHEN dna_sequence LIKE '%ATAT%' OR dna_sequence LIKE 'ATAT%' OR dna_sequence LIKE '%ATAT' OR dna_sequence LIKE '%ATAT%' OR dna_sequence LIKE 'ATAT%' OR dna_sequence LIKE '%ATAT' THEN 1
    ELSE 0
END AS has_atat,

CASE 
    WHEN dna_sequence LIKE '%GGG%' OR dna_sequence LIKE 'GGG%' OR dna_sequence LIKE '%GGG' OR dna_sequence LIKE '%GGGG%' OR dna_sequence LIKE 'GGGG%' OR dna_sequence LIKE '%GGGG' THEN 1
    ELSE 0
END AS has_ggg


from Samples
