ALTER TABLE [Route]
ADD CONSTRAINT start_location FOREIGN KEY (from_id) REFERENCES [Location] (id);
ALTER TABLE [Route]
ADD CONSTRAINT end_location FOREIGN KEY (to_id) REFERENCES [Location] (id);
ALTER TABLE Problem
ADD CONSTRAINT start_point_to_find_route FOREIGN KEY (from_id) REFERENCES [Location] (id);
ALTER TABLE Problem
ADD CONSTRAINT end_point_to_find_route FOREIGN KEY (to_id) REFERENCES [Location] (id);
ALTER TABLE Solution
ADD CONSTRAINT reference_to_problem FOREIGN KEY (problem_id) REFERENCES Problem (id);