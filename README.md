# MIN 2 - DSA

Canvis realitzats:
- S'ha afegit el layout item_team_ranking.xml
- S'ha afegit el layout activity_team_ranking.xml
- S'ha afegit la ruta /teams/ranking a l'ApiService
- S'ha creat el TeamRankingAdapter
- S'ha creat el TeamRankingActivity

Conclusió:
- S'ha implementat tot el que es solicitava en l'EJ1 del MÍN 2.

# 🎣 Fish & Chill: Fishing & PvP Combat

Welcome to the central repository for **Fish & Chill**! This project is a multiplayer fishing simulation game with a twist: survival and Player-vs-Player (PvP) competition.

Developed as a project for the **Disseny i Servei d'Aplicacions (DSA)** course at the UPC.


## 🌟 Game Concept

Fish & Chill places you in a world where the tranquility of fishing merges with the adrenaline of competition.

Travel through various lakes and fishing areas and capture unique species. But beware! Other players can challenge you to steal your coveted fishing *spot* by eliminating you with their rod, which also functions as a weapon.


### Key Features

* **Multi-Zone Fishing:** Explore different biomes and lakes to find rare fish species.
* **PvP Combat for Spots:** Eliminate other users from fishing zones using your rod as a makeshift weapon to secure your place.
* **Game Economy:** A complete shop system to **buy** new rods (weapons and fishing tools) and **sell** your catches.


## ⚙️ Project Structure

The project is divided into two main repositories following a client-server architecture:

| **Backend (API)** | [JoelRojasLlauradoUPC/DSA_FishandChill_Backend](https://github.com/JoelRojasLlauradoUPC/DSA_FishandChill_Backend.git) |
| **Frontend (Client)** | [Judiiiit/DSA_FishandChill_Frontend](https://github.com/Judiiiit/DSA_FishandChill_Frontend.git) |


## 💻 Backend API

The backend exposes a simple RESTful game API with authentication, item catalog, in-game actions, and a shop.
