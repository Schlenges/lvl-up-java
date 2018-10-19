INSERT INTO skills(ID, name, curr_lvl, max_lvl, curr_xp) VALUES (1, 'Programming', 5, 20, 30);
INSERT INTO battles(ID, description, xp) VALUES (01, '30 minutes freeCodeCamp', 20);
INSERT INTO battles(ID, description, xp) VALUES (02, 'Java Tutorial', 50);
INSERT INTO SKILLS_BATTLES(SKILL_ID, BATTLES_ID) VALUES (1, 01);
INSERT INTO SKILLS_BATTLES(SKILL_ID, BATTLES_ID) VALUES (1, 02);