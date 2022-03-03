build: src/data/AudioLibrary.java src/data/Event.java src/data/LibLibrary.java src/data/TextureLibrary.java src/data/Tile.java src/data/TileBallista.java src/data/TileKey.java src/data/TileLibrary.java src/data/TileLock.java src/data/TileSign.java src/data/TileSpawner.java src/data/TileSpikeTrap.java src/entities/Entity.java src/entities/EntityBolt.java src/entities/EntityEnemy.java src/graphics/Animation.java src/graphics/GameI.java src/graphics/Message.java src/graphics/Particle.java src/graphics/Screen.java src/levels/Level.java src/main/Main.java src/resources/*
	javac -d bin src/*/*.java
run: bin/*/*.class
	java -classpath bin main.Main

