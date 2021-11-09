DROP DATABASE  IF EXISTS `Reddit_Reader`;

CREATE DATABASE  IF NOT EXISTS `Reddit_Reader`;
USE `Reddit_Reader`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users` 
VALUES 
('admin1','password'),
('admin2','password');


--
-- Table structure for table `subreddits`
--

DROP TABLE IF EXISTS `subreddits`;
CREATE TABLE `subreddits` (
  `username` varchar(50) NOT NULL,
  `subreddit` varchar(50) NOT NULL,
  `profile` varchar(50) NOT NULL,
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
