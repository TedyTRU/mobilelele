-- some test users
INSERT INTO users (id, email, first_name, last_name, image_url, is_active, password)
VALUES (1, 'lachezar.balev@gmail.com', 'Lucho', 'Balev', null, 1,
        '57e7759fd2d59275fc3c3cd5dd2ace5013b39ee972999412f3f5f5c3382b6765c2571ef86648abe2');


INSERT INTO brands(id, name)
VALUES (1, 'Ford'),
       (2, 'Toyota'),
       (3, 'Nissan'),
       (4, 'Opel'),
       (5, 'Kia');

INSERT INTO models(id, category, start_year, end_year, name, brand_id, image_url)
VALUES (1, 'CAR', 1976, null, 'Fiesta', 1,
        'https://static.motor.es/fotos-noticias/2021/11/precio-ford-fiesta-2022-202183060-1638099043_1.jpg'),
       (2, 'CAR', 1999, null, 'Yaris', 2,
        'https://www.motortrend.com/uploads/sites/10/2015/11/2014-toyota-yaris-le-3-door-hatchback-angular-front.png'),
       (3, 'CAR', 2012, null, 'Sportage', 5,
        'https://hips.hearstapps.com/hmg-prod/images/18050-2023-sportage-x-pro-1635358262.jpg?crop=0.697xw:0.784xh;0.204xw,0.0721xh&resize=640:*'),
       (4, 'CAR', 1968, 2000, 'Escort', 1, 'https://www.auto-data.net/images/f110/Ford-Escort-VII-Hatch-GAL-AFL.jpg');


