ALTER TABLE books
ADD CONSTRAINT unique_title_author UNIQUE (title, author);
