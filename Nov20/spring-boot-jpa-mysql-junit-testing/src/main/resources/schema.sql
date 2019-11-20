DROP TABLE IF EXISTS `user`;
CREATE TABLE  `user` (
  `user_id` int(11) NOT NULL auto_increment,
   `user_name` varchar(255) NOT NULL,
  `user_email` varchar(255) default NULL,
  PRIMARY KEY  (`user_id`)
) ;
