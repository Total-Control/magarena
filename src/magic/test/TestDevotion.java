package magic.test;

import magic.model.MagicDuel;
import magic.model.MagicGame;
import magic.model.MagicPlayer;
import magic.model.phase.MagicMainPhase;

class TestDevotion extends TestGameBuilder {
    @Override
    public MagicGame getGame() {
        final MagicDuel duel=createDuel();
        final MagicGame game=duel.nextGame();
        game.setPhase(MagicMainPhase.getFirstInstance());
        final MagicPlayer player=game.getPlayer(0);
        final MagicPlayer opponent=game.getPlayer(1);

        MagicPlayer P = player;

        P.setLife(6);
        addToLibrary(P, "Forest", 20);
        addToLibrary(P, "Island", 20);
        addToLibrary(P, "Entreat the Angels", 20);
        addToLibrary(P, "Sliver Overlord", 1);
        addToLibrary(P, "Wingsteed Rider", 1);
        addToGraveyard(P, "Ink-Eyes, Servant of Oni", 3);
        createPermanent(P, "Rupture Spire", false, 9);
        addToHand(P, "Rupture Spire", 1);
        addToHand(P, "Abhorrent Overlord", 1);
        addToHand(P, "Purphoros, God of the Forge", 1);
        addToHand(P, "Dwarven Pony", 5);

        P = opponent;

        P.setLife(20);
        addToLibrary(P, "Mountain", 20);
        createPermanent(P,"Rupture Spire",false,9);
        createPermanent(P, "Grizzly Bears", false, 1);
        addToHand(P, "Trained Jackal", 1);
        addToGraveyard(P, "Ink-Eyes, Servant of Oni", 1);

        return game;
    }
}
