[
    new MagicPermanentActivation(
        new MagicActivationHints(MagicTiming.Attack),
        "Unblockable"
    ) {

        @Override
        public Iterable<MagicEvent> getCostEvent(final MagicPermanent source) {
            return [
            new MagicPayManaCostEvent(source,"{2}"),
            new MagicBounceChosenPermanentEvent(source, MagicTargetChoice.LAND_YOU_CONTROL)
            ];
        }

        @Override
        public MagicEvent getPermanentEvent(final MagicPermanent source,final MagicPayedCost payedCost) {
            return new MagicEvent(
                source,
                MagicTargetChoice.TARGET_CREATURE_POWER_2_OR_LESS,
                MagicUnblockableTargetPicker.create(),
                this,
                "Target creature\$ with power 2 or less is unblockable this turn."
            );
        }

        @Override
        public void executeEvent(final MagicGame game, final MagicEvent event) {
            event.processTargetPermanent(game, {
                final MagicPermanent creature ->
                game.doAction(new MagicGainAbilityAction(creature,MagicAbility.Unblockable));
            });
        }
    }
]
