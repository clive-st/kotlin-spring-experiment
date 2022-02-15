INSERT INTO show_time (imdb_id, day, hour, minute, price) VALUES
  ('tt0232500', 1, 20, 12, 66),
  ('tt0322259', 1, 20, 12, 66),
  ('tt0463985', 1, 20, 12, 66),
  ('tt1013752', 1, 20, 12, 66),
  ('tt1596343', 1, 20, 12, 66),
  ('tt1905041', 1, 20, 12, 66),
  ('tt2820852', 1, 20, 12, 66),
  ('tt4630562', 1, 20, 12, 66),
  ('tt5433138', 1, 20, 12, 66);

INSERT INTO movie_in_theater (title, imdb_id) VALUES
  ('The Fast and the Furious',	'tt0232500'),
  ('2 Fast 2 Furious', 'tt0322259'),
  ('The Fast and the Furious: Tokyo Drift',	'tt0463985'),
  ('Fast & Furious','tt1013752'),
  ('Fast Five',	'tt1596343'),
  ('Fast & Furious 6',	'tt1905041'),
  ('Furious 7',	'tt2820852'),
  ('The Fate of the Furious','tt4630562'),
  ('F9: The Fast Saga',	'tt5433138');


INSERT INTO movie_rating (imdb_id, rating,user_name, id) VALUES
  ('tt4630562', 5 ,'John',0),
  ('tt4630562', 2 ,'Tom',1);