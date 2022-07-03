CREATE DATABASE cooking_project;

CREATE SCHEMA cooking;

-- пользователь
-- (слово user уже зарезервировано, поэтому таблица названа users)
CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    email    VARCHAR(128) UNIQUE NOT NULL,
    password VARCHAR(128)        NOT NULL,
    is_admin BOOLEAN             NOT NULL
);

-- детали пользователя
CREATE TABLE user_details
(
    user_id    INTEGER REFERENCES users (id) PRIMARY KEY,
    first_name VARCHAR(128) NOT NULL,
    last_name  VARCHAR(128) NOT NULL,
    birthday   TIMESTAMP    NOT NULL
);

-- ингредиценты
CREATE TABLE ingredient
(
    id                       SERIAL PRIMARY KEY,
    name                     VARCHAR(128) UNIQUE NOT NULL,
    weight_of_one_piece_gram INTEGER,
    kilocalories             INTEGER             NOT NULL,
    protein_mg               INTEGER,
    fat_mg                   INTEGER,
    carbohydrate_mg          INTEGER
);

-- приправы
CREATE TABLE spices
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(128) UNIQUE NOT NULL
);

-- рецепты
CREATE TABLE recipe
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(128) UNIQUE NOT NULL
);

-- детали рецепта
-- (время приготовление разделено на активное (сама готовка)
-- и общее (включая время на запекание, маринад и т.п.))
-- user_id - id пользователя, создавшего рецепт
CREATE TABLE recipe_detail
(
    recipe_id                  INTEGER REFERENCES recipe (id) PRIMARY KEY,
    user_id                    INTEGER REFERENCES users (id),
    description                TEXT,
    active_cooking_time_minute INTEGER,
    total_cooking_time_minute  INTEGER
);

-- шаги приготовления рецепта
-- (one to many - у одного рецепта может быть несколько шагов)
CREATE TABLE recipe_steps
(
    recipe_id        INTEGER REFERENCES recipe (id),
    step_number      INTEGER      NOT NULL,
    step_description VARCHAR(256) NOT NULL,
    PRIMARY KEY (recipe_id, step_number)
);

-- соединение рецепт + ингредиент
CREATE TABLE recipe_ingredient
(
    recipe_id     INTEGER REFERENCES recipe (id),
    ingredient_id INTEGER REFERENCES ingredient (id),
    gram          INTEGER,
    notes         VARCHAR(128),
    PRIMARY KEY (recipe_id, ingredient_id)
);

-- соединение: рецепт + приправа
CREATE TABLE recipe_spices
(
    recipe_id INTEGER REFERENCES recipe (id),
    spicy_id  INTEGER REFERENCES spices (id),
    notes     VARCHAR(128),
    PRIMARY KEY (recipe_id, spicy_id)
);


-- соединение: юзер + рецепт (избранные рецепты)
CREATE TABLE user_favorite_recipes
(
    user_id   INTEGER REFERENCES users (id),
    recipe_id INTEGER REFERENCES recipe (id),
    PRIMARY KEY (user_id, recipe_id)
);

-- план питания
CREATE TABLE meal_plan
(
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(128) NOT NULL,
    user_id INTEGER REFERENCES users (id),
    UNIQUE (user_id, name)
);

-- виды приёмов пищи (например, завтрак, перекус, обед)
CREATE TABLE meal_type
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(64) NOT NULL UNIQUE
);

-- один день в плане питания
CREATE TABLE meal_plan_day
(
    id           SERIAL PRIMARY KEY,
    meal_plan_id INTEGER REFERENCES meal_plan (id),
    day_number   INTEGER NOT NULL,
    UNIQUE (meal_plan_id, day_number)
);

-- связь дня плана питания с рецептом
CREATE TABLE meal_plan_recipe
(
    meal_plan_day_id INTEGER REFERENCES meal_plan_day (id),
    recipe_id        INTEGER REFERENCES recipe (id),
    meal_type_id     INTEGER REFERENCES meal_type (id),
    PRIMARY KEY (meal_plan_day_id, meal_type_id)
);

-- связь плана питания с ингредиентом
-- (в качестве приема пищи может выступать отдельно взятый ингредиент)
CREATE TABLE meal_plan_ingredient
(
    meal_plan_day_id INTEGER REFERENCES meal_plan_day (id),
    ingredient_id    INTEGER REFERENCES ingredient (id),
    meal_type_id     INTEGER REFERENCES meal_type (id),
    PRIMARY KEY (meal_plan_day_id, meal_type_id)
);