[
    new MagicPermanentActivation(
        new MagicActivationHints(MagicTiming.Token),
        "Copy"
    ) {

        @Override
        public MagicEvent[] getCostEvent(final MagicPermanent source) {
            return [new MagicPayManaCostTapEvent(source,"{3}")];
        }

        @Override
        public MagicEvent getPermanentEvent(final MagicPermanent source,final MagicPayedCost payedCost) {
            return new MagicEvent(
                source,
                this,
                "PN puts a token that's a copy of SN onto the battlefield."
            );
        }

        @Override
        public void executeEvent(final MagicGame game, final MagicEvent event) {
            final MagicPlayer player = event.getPlayer();
            final MagicPermanent permanent = event.getPermanent();
            final MagicCard card = MagicCard.createTokenCard(permanent.getCardDefinition(),player);
            game.doAction(new MagicPlayCardAction(card,player));
        }
    }
]
