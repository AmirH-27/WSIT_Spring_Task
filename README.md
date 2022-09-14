# WSIT_Spring_Task
->CRUD
-> Rest
-> One to One, Many to One, Many to Many 
![wsit_task](https://user-images.githubusercontent.com/65022657/189900954-144568e1-fe67-40b5-ba60-e3336ba44288.png)


SQL COMMANDS->

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `user_details_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_id_uindex` (`id`),
  KEY `users_user_details_user_details_id_fk` (`user_details_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `user_details` (
  `user_details_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `image_path` varchar(100) DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  PRIMARY KEY (`user_details_id`),
  KEY `user_details_courses_id_fk` (`course_id`),
  CONSTRAINT `user_details_courses_user_details_id_fk` FOREIGN KEY (`user_details_id`) REFERENCES `courses` (`user_details_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_details_users_user_details_id_fk` FOREIGN KEY (`user_details_id`) REFERENCES `users` (`user_details_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `courses` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `course_name` varchar(20) DEFAULT NULL,
  `course_code` varchar(20) DEFAULT NULL,
  `user_details_id` int DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `courses_user_details_user_details_id_fk` (`user_details_id`),
  CONSTRAINT `courses_user_details_course_id_fk` FOREIGN KEY (`course_id`) REFERENCES `user_details` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


Create a datasource using datagrip or any other ide

Copy the link of your datasourse and go to this directory https://github.com/AmirH-27/WSIT_Spring_Task/blob/main/demo/src/main/java/com/example/demo/config/AppConfig.java

Replace the existing datasourse link and the username and password(if applicable)

