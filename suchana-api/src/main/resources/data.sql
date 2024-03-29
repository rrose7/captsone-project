insert into tags(tagId, name) values (1, 'Sports');
insert into tags(tagId, name) values (2, 'Politics');
insert into tags(tagId, name) values (3, 'Science');
insert into tags(tagId, name) values (4, 'Entertainment');

-- insert categories
insert into category(id, name) values (1, 'Sports');
insert into category(id, name) values (2, 'Politics');
insert into category(id, name) values (3, 'Entertainment');

-- insert user
insert into user(id, firstName, lastName, username, password, role) values (1, 'Dheeraj', 'Karki', 'dheerajkarki','$2a$10$2XQT0tRrvvQ.1xzLcn9CLO6SjRYMAUWaNj2LMjQs6vyMTAW6P.x3i','ROLE_ADMIN');
insert into user(id, firstName, lastName, username, password, role) values (2, 'Saurav', 'Shrestha','sauravshrestha','$2a$10$BZy.5OVNc3ptut7/MwfWneHfjbGlsEu8CgeojHia.rxZzxiozAwKy', 'ROLE_AUTHOR');
insert into user(id, firstName, lastName, username, password, role) values (3, 'Roshan', 'Dhakal','roshandhakal1','$2a$10$hfwbW.6/RHvYlOhBlZMFIO9MQmy48dC2E/V9CNaEJrrsXNmaFV3sq', 'ROLE_ADMIN');
insert into user(id, firstName, lastName, username, password, role) values (4, 'Nabin', 'Karki','nabinkarki1','$2a$10$i5YakvDG8jU8GeT/a9jdkexB0C9lrAgQSyirGOrhEiqRkY.7dD/RS', 'ROLE_AUTHOR');

-- insert user with category
insert into author_category(author_id,category_id) values (1,1);
insert into author_category(author_id,category_id) values (1,3);
insert into author_category(author_id,category_id) values (2,3);
insert into author_category(author_id,category_id) values (3,1);
insert into author_category(author_id,category_id) values (3,2);
insert into author_category(author_id,category_id) values (4,2);

-- insert into articles
insert into article(id,title,content,publishDate,noOfViews, author_id, category_id) values (1, 'Legendary NBA coach Jerry Sloan ''dying'' while battling dementia, Parkinson''s disease: report', 'Salt Lake Tribune columnist Gordon Monson gave an update on Sloan’s health Wednesday, writing that he asked someone outside the family who would know the details about the coach’s health and received an eerie response.','2019-07-28T13:56:17.538',0, 1 ,1);
insert into article(id,title,content,publishDate,noOfViews, author_id, category_id) values (2, 'Trump''s comments on black lawmaker hyperbole, not racism: top aide', 'President Donald Trump was speaking hyperbolically when he lashed out at a prominent African-American lawmaker by calling his district "disgusting, rat and rodent infested," his acting chief of staff said on Sunday, denying the comments were racist.','2019-06-28T13:56:17.538',0, 3 ,2);
insert into article(id,title,content,publishDate,noOfViews, author_id, category_id) values (3, 'Shawn Mendes and Camila Cabello Spotted Holding Hands & Cuddling Up in Tampa Amid Ongoing Dating Rumors','The singers, and recent collaborators on the track "Senorita," were spotted out and about in Tampa, Florida, on Saturday, and were photographed getting close and cozy by some fans.','2019-05-28T13:56:17.538',0, 2 ,3);

-- insert article_tag
insert into article_tag(article_id,tag_id) values (1,1);
insert into article_tag(article_id,tag_id) values (2,2);