package com.gmail.goosius.siegewar.settings;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.EnumSet;
import java.util.ArrayList;
import java.util.Locale;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;

import com.gmail.goosius.siegewar.SiegeController;
import com.gmail.goosius.siegewar.SiegeWar;
import com.gmail.goosius.siegewar.objects.HeldItemsCombination;
import com.palmergames.bukkit.towny.exceptions.TownyException;
import com.palmergames.bukkit.towny.object.Nation;
import org.bukkit.Material;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.*;
import org.jetbrains.annotations.Nullable;

public class SiegeWarSettings {

	private static List<HeldItemsCombination> mapHidingItems = null;
	private static List<DayOfWeek> allowedDaysList = null;
	private static List<Material> siegeZoneWildernessForbiddenBlockMaterials = null;
	private static List<Material> siegeZoneWildernessForbiddenBucketMaterials = null;
	private static List<EntityType> siegeZoneWildernessForbiddenExplodeEntityTypes = null;
	@SuppressWarnings("unused")
    private static EnumSet<Material> cachedWallBreachingPlaceBlocksWhitelist = null;
	@SuppressWarnings("unused")
    private static EnumSet<Material> cachedWallBreachingDestroyBlocksBlacklist = null;
	@SuppressWarnings("unused")
    private static Boolean cachedWallBreachingDestroyEntityBlacklist = null;

	protected static void resetCachedSettings() {
		allowedDaysList = null;
		siegeZoneWildernessForbiddenBlockMaterials = null;
		siegeZoneWildernessForbiddenBucketMaterials = null;
		siegeZoneWildernessForbiddenExplodeEntityTypes = null;
		cachedWallBreachingPlaceBlocksWhitelist = null;
		cachedWallBreachingDestroyBlocksBlacklist = null;
		cachedWallBreachingDestroyEntityBlacklist = null;
	}

	public static boolean getWarSiegeEnabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_ENABLED);
	}

	public static boolean getWarSiegeAbandonEnabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_ABANDON_ENABLED);
	}

	public static boolean getWarSiegeSurrenderEnabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_SURRENDER_ENABLED);
	}

	public static boolean getWarSiegeInvadeEnabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_INVADE_ENABLED);
	}

	public static boolean getWarSiegePlunderEnabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_PLUNDER_ENABLED);
	}

	public static boolean getWarSiegeMilitarySalaryEnabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_MILITARY_SALARY_ENABLED);
	}

	public static boolean getConquestSiegesEnabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_CONQUEST_SIEGES_ENABLED);
	}

	public static boolean getLiberationSiegesEnabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_LIBERATION_SIEGES_ENABLED);
	}

	public static boolean getRevoltSiegesEnabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_REVOLT_SIEGES_ENABLED);
	}

	public static boolean getSuppressionSiegesEnabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_SUPPRESSION_SIEGES_ENABLED);
	}

	public static boolean getWarSiegeClaimingDisabledNearSiegeZones() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_CLAIMING_DISABLED_NEAR_SIEGE_ZONES);
	}

	public static double getWarSiegeAttackerCostUpFrontPerPlot() {
		return Settings.getDouble(ConfigNodes.WAR_SIEGE_ATTACKER_COST_UPFRONT_PER_PLOT);
	}

	public static double getWarSiegeSiegeImmunityTimeNewTownsHours() {
		return Settings.getDouble(ConfigNodes.WAR_SIEGE_SIEGE_IMMUNITY_TIME_NEW_TOWN_HOURS);
	}

	public static double getWarSiegeSiegeImmunityTimeModifier() {
		return Settings.getDouble(ConfigNodes.WAR_SIEGE_SIEGE_IMMUNITY_TIME_MODIFIER);
	}

	public static double getWarSiegeRevoltImmunityTimeModifier() {
		return Settings.getDouble(ConfigNodes.WAR_SIEGE_REVOLT_IMMUNITY_TIME_MODIFIER);
	}

	public static double getWarSiegeAttackerPlunderAmountPerPlot() {
		return Settings.getDouble(ConfigNodes.WAR_SIEGE_ATTACKER_PLUNDER_AMOUNT_PER_PLOT);
	}

	public static double getWarSiegeMaxHoldoutTimeHours() {
		return Settings.getDouble(ConfigNodes.WAR_SIEGE_MAX_HOLDOUT_TIME_HOURS);
	}
	
	public static double getWarSiegeMinSiegeDurationBeforeSurrenderHours() {
		return Settings.getDouble(ConfigNodes.WAR_SIEGE_MIN_SIEGE_DURATION_BEFORE_SURRENDER_HOURS);
	}

	public static double getWarSiegeMinSiegeDurationBeforeAbandonHours() {
		return Settings.getDouble(ConfigNodes.WAR_SIEGE_MIN_SIEGE_DURATION_BEFORE_ABANDON_HOURS);
	}
	
	public static boolean areBattlePointsWinnerTakesAll() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_POINTS_BALANCING_END_OF_BATTLE_POINTS_DISTRIBUTION_WINNER_TAKES_ALL);
	}

	public static int getWarBattlePointsForAttackerOccupation() {
		return Settings.getInt(ConfigNodes.WAR_SIEGE_POINTS_BALANCING_BASE_POINTS_BANNER_CONTROL_ATTACKER);
	}

	public static int getWarBattlePointsForDefenderOccupation() {
		return Settings.getInt(ConfigNodes.WAR_SIEGE_POINTS_BALANCING_BASE_POINTS_BANNER_CONTROL_DEFENDER);
	}

	public static int getWarBattlePointsForAttackerDeath() {
		return Settings.getInt(ConfigNodes.WAR_SIEGE_POINTS_BALANCING_BASE_POINTS_BANNER_CONTROL_DEATHS_ATTACKER);
	}

	public static int getWarBattlePointsForDefenderDeath() {
		return Settings.getInt(ConfigNodes.WAR_SIEGE_POINTS_BALANCING_BASE_POINTS_BANNER_CONTROL_DEATHS_DEFENDER);
	}
	
	public static int getWarSiegeZoneRadiusBlocks() {
		return Settings.getInt(ConfigNodes.WAR_SIEGE_ZONE_RADIUS_BLOCKS);
	}

	public static boolean getWarSiegeNonResidentSpawnIntoSiegeZonesOrBesiegedTownsDisabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_NON_RESIDENT_SPAWN_INTO_SIEGE_ZONES_OR_BESIEGED_TOWNS_DISABLED);
	}

	public static int getWarSiegeMaxActiveSiegeAttacksPerNation() {
		return Settings.getInt(ConfigNodes.WAR_SIEGE_MAX_ACTIVE_SIEGE_ATTACKS_PER_NATION);
	}

	public static boolean doesThisNationHaveTooManyActiveSieges(Nation nation) {
		return SiegeController.getActiveOffensiveSieges(nation).size() >= getWarSiegeMaxActiveSiegeAttacksPerNation();
	}

	public static boolean getWarCommonPeacefulTownsEnabled() {
		return Settings.getBoolean(ConfigNodes.PEACEFUL_TOWNS_ENABLED);
	}

	public static int getWarCommonPeacefulTownsConfirmationRequirementDays() {
		return Settings.getInt(ConfigNodes.PEACEFUL_TOWNS_CONFIRMATION_REQUIREMENT_DAYS);
	}

	public static boolean getWarSiegeBesiegedTownRecruitmentDisabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_BESIEGED_TOWN_RECRUITMENT_DISABLED);
	}

	public static boolean getWarSiegeBesiegedTownClaimingDisabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_BESIEGED_TOWN_CLAIMING_DISABLED);
	}

	public static boolean getWarSiegeBesiegedTownUnClaimingDisabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_BESIEGED_TOWN_UNCLAIMING_DISABLED);
	}
	
	public static boolean getWarSiegeBesiegedCapitalsCannotChangeKing() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_BESIEGED_TOWN_CANNOT_CHANGE_KING);
	}

	public static boolean getWarSiegeDeathPenaltyKeepInventoryEnabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_DEATH_PENALTY_KEEP_INVENTORY_ENABLED);
	}

	public static boolean getWarSiegeDeathPenaltyKeepLevelEnabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_DEATH_PENALTY_KEEP_LEVEL_ENABLED);
	}

	public static boolean getWarSiegeDeathPenaltyDegradeInventoryEnabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_DEATH_PENALTY_DEGRADE_INVENTORY_ENABLED);
	}

	public static double getWarSiegeDeathPenaltyDegradeInventoryPercentage() {
		return Settings.getDouble(ConfigNodes.WAR_SIEGE_DEATH_PENALTY_DEGRADE_INVENTORY_PERCENTAGE);
	}

	public static int getWarSiegeExtraMoneyPercentagePerTownLevel() {
		return Settings.getInt(ConfigNodes.WAR_SIEGE_EXTRA_MONEY_PERCENTAGE_PER_TOWN_LEVEL);
	}

	public static boolean getWarSiegeMapHidingEnabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_MAP_HIDING_ENABLED);
	}

	public static boolean getWarSiegeMapHidingModeAutomaticModeEnabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_MAP_HIDING_AUTOMATIC_MODE_ENABLED);
	}

	public static boolean getWarSiegeMapHidingModeAutomaticModeScopeWilderness() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_MAP_HIDING_AUTOMATIC_MODE_SCOPE_WILDERNESS);
	}

	public static boolean getWarSiegeMapHidingModeAutomaticModeScopeBesiegedTowns() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_MAP_HIDING_AUTOMATIC_MODE_SCOPE_BESIEGED_TOWNS);
	}

	public static boolean getWarSiegeMapHidingModeAutomaticModeScopeRuins() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_MAP_HIDING_AUTOMATIC_MODE_SCOPE_RUINS);
	}

	public static boolean getWarSiegeMapHidingModeAutomaticModeScopeSiegezones() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_MAP_HIDING_AUTOMATIC_MODE_SCOPE_SIEGEZONES);
	}

	public static double getWarSiegeMapHidingModeAutomaticModeScopeSiegezonesRadius() {
		return Settings.getDouble(ConfigNodes.WAR_SIEGE_MAP_HIDING_AUTOMATIC_MODE_SCOPE_SIEGEZONES_RADIUS);
	}

	public static boolean getWarSiegeMapHidingTriggeringEnabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_MAP_HIDING_TRIGGERING_ENABLED);
	}

	public static List<HeldItemsCombination> getWarSiegeMapHidingTriggeringItems() {
		try {
			if (mapHidingItems == null) {
				mapHidingItems = new ArrayList<>();
				String itemsListAsString = Settings.getString(ConfigNodes.WAR_SIEGE_MAP_HIDING_TRIGGERING_ITEMS);
				String[] itemsListAsArray = itemsListAsString.split(",");
				String[] itemPair;
				boolean ignoreOffHand;
				boolean ignoreMainHand;
				Material offHandItem;
				Material mainHandItem;

				for (String itemAsString : itemsListAsArray) {
					itemPair = itemAsString.trim().split("\\|");

					if(itemPair[0].equalsIgnoreCase("any")) {
						ignoreOffHand = true;
						offHandItem = null;
					} else if (itemPair[0].equalsIgnoreCase("empty")){
						ignoreOffHand = false;
						offHandItem = Material.AIR;
					} else{
						ignoreOffHand = false;
						offHandItem = Material.matchMaterial(itemPair[0]);
					}

					if(itemPair[1].equalsIgnoreCase("any")) {
						ignoreMainHand = true;
						mainHandItem = null;
					} else if (itemPair[1].equalsIgnoreCase("empty")){
						ignoreMainHand = false;
						mainHandItem = Material.AIR;
					} else{
						ignoreMainHand = false;
						mainHandItem = Material.matchMaterial(itemPair[1]);
					}

					mapHidingItems.add(
							new HeldItemsCombination(offHandItem,mainHandItem,ignoreOffHand,ignoreMainHand));
				}
			}
		} catch (Exception e) {
			SiegeWar.severe("Problem reading map hiding items list. The list is config.yml may be misconfigured.");
			e.printStackTrace();
		}
		return mapHidingItems;
	}

	public static int getWarSiegeBannerControlSessionDurationMinutes() {
		return Settings.getInt(ConfigNodes.WAR_SIEGE_BANNER_CONTROL_SESSION_DURATION_MINUTES);
	}

	public static boolean getWarCommonOccupiedTownUnClaimingDisabled() {
		return Settings.getBoolean(ConfigNodes.OCCUPIED_TOWN_UNCLAIMING_DISABLED);
	}
	
	public static boolean getWarCommonOccupiedTownCorrectConquerStatus() {
		return Settings.getBoolean(ConfigNodes.OCCUPIED_TOWN_CORRECT_CONQUERED_STATUS);
	}

	public static boolean isWarSiegeCounterattackBoosterEnabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_POINTS_BALANCING_COUNTERATTACK_BOOSTER_ENABLED);
	}

	public static double getWarSiegeCounterattackBoosterExtraDeathPointsPerPlayerPercentage() {
		return Settings.getDouble(ConfigNodes.WAR_SIEGE_POINTS_BALANCING_COUNTERATTACK_BOOSTER_EXTRA_DEATH_POINTS_PER_PLAYER_PERCENTAGE);
	}

	public static List<Material> getSiegeZoneWildernessForbiddenBlockMaterials() {
		if(siegeZoneWildernessForbiddenBlockMaterials == null) {
			siegeZoneWildernessForbiddenBlockMaterials = new ArrayList<>();
			String listAsString = Settings.getString(ConfigNodes.SIEGE_MATERIAL_RESTRICTIONS_WILDERNESS_BLOCK_PLACEMENT_PREVENTION_MATERIALS);
			String[] listAsStringArray = listAsString.split(",");
			for (String blockTypeAsString : listAsStringArray) {
				Material material = Material.matchMaterial(blockTypeAsString.trim());
				siegeZoneWildernessForbiddenBlockMaterials.add(material);
			}
		}
		return siegeZoneWildernessForbiddenBlockMaterials;
	}

	public static List<Material> getSiegeZoneWildernessForbiddenBucketMaterials() {
		if(siegeZoneWildernessForbiddenBucketMaterials == null) {
			siegeZoneWildernessForbiddenBucketMaterials = new ArrayList<>();
			String listAsString = Settings.getString(ConfigNodes.SIEGE_MATERIAL_RESTRICTIONS_WILDERNESS_BUCKET_EMPTYING_PREVENTION_MATERIALS);
			String[] listAsStringArray = listAsString.split(",");
			for (String blockTypeAsString : listAsStringArray) {
				Material material = Material.matchMaterial(blockTypeAsString.trim());
				siegeZoneWildernessForbiddenBucketMaterials.add(material);
			}
		}
		return siegeZoneWildernessForbiddenBucketMaterials;
	}

	public static List<EntityType> getSiegeZoneWildernessForbiddenExplodeEntityTypes() {
		if(siegeZoneWildernessForbiddenExplodeEntityTypes == null) {
			siegeZoneWildernessForbiddenExplodeEntityTypes = new ArrayList<>();
			String listAsString = Settings.getString(ConfigNodes.SIEGE_MATERIAL_RESTRICTIONS_WILDERNESS_EXPLOSION_PREVENTION_ENTITY_TYPES);
			String[] listAsStringArray = listAsString.split(",");
			for (String entityTypeAsString : listAsStringArray) {
				EntityType entityType = EntityType.valueOf(entityTypeAsString.trim().toUpperCase(Locale.ROOT));
				siegeZoneWildernessForbiddenExplodeEntityTypes.add(entityType);
			}
		}
		return siegeZoneWildernessForbiddenExplodeEntityTypes;
	}

	public static boolean isPeacefulTownsSubvertEnabled() {
		return Settings.getBoolean(ConfigNodes.PEACEFUL_TOWNS_SUBVERT_ENABLED);
	}

	public static boolean isPeacefulTownsRevoltEnabled() {
		return Settings.getBoolean(ConfigNodes.PEACEFUL_TOWNS_PEACEFUL_REVOLT_ENABLED);
	}

	public static int getPeacefulTownsTownyInfluenceRadius() {
		return Settings.getInt(ConfigNodes.PEACEFUL_TOWNS_TOWNY_INFLUENCE_RADIUS);
	}

	public static int getPeacefulTownsSicknessWarningDurationSeconds() {
		return Settings.getInt(ConfigNodes.PEACEFUL_TOWNS_SICKNESS_WARNING_DURATION_SECONDS);
	}

	public static int getWarCommonPeacefulTownsNewTownConfirmationRequirementDays() {
		return Settings.getInt(ConfigNodes.PEACEFUL_TOWNS_NEW_TOWN_CONFIRMATION_REQUIREMENT_DAYS);
	}

	public static int getBannerControlVerticalDistanceUpBlocks() {
		return Settings.getInt(ConfigNodes.WAR_SIEGE_BANNER_CONTROL_VERTICAL_DISTANCE_UP_BLOCKS);
	}
	
	public static int getBannerControlVerticalDistanceDownBlocks() {
		return Settings.getInt(ConfigNodes.WAR_SIEGE_BANNER_CONTROL_VERTICAL_DISTANCE_DOWN_BLOCKS);
	}

	public static boolean getPunishingNonSiegeParticipantsInSiegeZone() {
		return Settings.getBoolean(ConfigNodes.ENABLE_SICKNESS);
	}

	public static int getNonResidentSicknessWarningTimeSeconds() {
		return Settings.getInt(ConfigNodes.SECONDS_BEFORE_SICKNESS);
	}

	public static double getWarSiegeCapitalCostIncreasePercentage() {
		return Settings.getDouble(ConfigNodes.WAR_SIEGE_CAPITAL_SIEGE_COST_INCREASE_PERCENTAGE);
	}

	public static boolean getWarSiegeNationStatisticsEnabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_NATION_STATISTICS_ENABLED);
	}

	public static boolean getWarSiegeDeathSpawnFireworkEnabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_DEATH_SPAWN_FIREWORK);
	}

	public static boolean getBeaconsEnabled() {
		return Settings.getBoolean(ConfigNodes.BEACON_MARKERS_ENABLED);
	}

	public static String getBeaconCaptureColor() {
		return Settings.getString(ConfigNodes.BEACON_MARKERS_CAPTURE_COLOR);
	}

	public static String getBeaconCapturedColor() {
		return Settings.getString(ConfigNodes.BEACON_MARKERS_CAPTURED_COLOR);
	}

	public static String getBeaconEnemyColor() {
		return Settings.getString(ConfigNodes.BEACON_MARKERS_ENEMY_COLOR);
	}

	public static boolean isWarSiegeBannerControlReversalBonusEnabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_POINTS_BALANCING_BANNER_CONTROL_REVERSAL_BONUS_ENABLED);
	}

	public static double getWarSiegeBannerControlReversalBonusFactor() {
		return Settings.getDouble(ConfigNodes.WAR_SIEGE_POINTS_BALANCING_BANNER_CONTROL_REVERSAL_BONUS_MULTIPLIER_VALUE);
	}

	public static boolean isBannerXYZTextEnabled() {
		return Settings.getBoolean(ConfigNodes.BANNER_XYZ_TEXT_ENABLED);
	}

	public static boolean isTrapWarfareMitigationEnabled() {
		return Settings.getBoolean(ConfigNodes.TRAP_WARFARE_MITIGATION_ENABLED);
	}

	public static int getTrapWarfareMitigationRadiusBlocks() {
		return Settings.getInt(ConfigNodes.TRAP_WARFARE_MITIGATION_RADIUS_BLOCKS);
	}

	public static int getTrapWarfareMitigationUpperHeightLimit() {
		return Settings.getInt(ConfigNodes.TRAP_WARFARE_MITIGATION_UPPER_HEIGHT_LIMIT);
	}

	public static int getTrapWarfareMitigationLowerHeightLimit() {
		return Settings.getInt(ConfigNodes.TRAP_WARFARE_MITIGATION_LOWER_HEIGHT_LIMIT);
	}

	public static boolean isNationSiegeImmunityEnabled() {
		return Settings.getBoolean(ConfigNodes.NATION_SIEGE_IMMUNITY_ENABLED);
	}

	public static double getNationSiegeImmunityDurationModifier() {
		return Settings.getDouble(ConfigNodes.NATION_SIEGE_IMMUNITY_DURATION_MODIFIER);
	}

	public static double getNationSiegeImmunityHomeTownContributionToAttackCost() {
		return Settings.getDouble(ConfigNodes.NATION_SIEGE_IMMUNITY_HOME_TOWN_CONTRIBUTION_TO_ATTACK_COST);
	}

	public static String getBannerControlCaptureMessageColor() {
		return Settings.getString(ConfigNodes.BANNER_CONTROL_CAPTURE_MESSAGE_COLOR);
	}

	public static boolean areSiegeCampsEnabled() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_SIEGECAMPS_ENABLED);
	}
	
	public static long getFailedSiegeCampCooldown() {
		return Settings.getSeconds(ConfigNodes.WAR_SIEGE_SIEGECAMPS_COOLDOWN);
	}
	
	public static int getSiegeCampPointsForSuccess() {
		return Settings.getInt(ConfigNodes.WAR_SIEGE_SIEGECAMPS_POINTS);
	}
	
	public static int getSiegeCampPointsPerMinute() {
		return Settings.getInt(ConfigNodes.WAR_SIEGE_SIEGECAMPS_POINTS_PER_MINUTE);
	}
	
	public static int getSiegeCampDurationInMinutes() {
		return Settings.getInt(ConfigNodes.WAR_SIEGE_SIEGECAMPS_DURATION_IN_MINUTES);
	}

	public static int getCappingLimiterBattleSessions() {
		DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
		boolean weekend = dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;

		if(weekend) {
			return getCappingLimiterWeekendDayBattleSessions();
		} else {
			return getCappingLimiterWeekdayBattleSessions();
		}
	}

	private static int getCappingLimiterWeekdayBattleSessions() {
		return Settings.getInt(ConfigNodes.CAPPING_LIMITER_WEEKDAY_BATTLE_SESSIONS);
	}

	private static int getCappingLimiterWeekendDayBattleSessions() {
		return Settings.getInt(ConfigNodes.CAPPING_LIMITER_WEEKEND_DAY_BATTLE_SESSIONS);
	}

	public static List<DayOfWeek> getSiegeStartDayLimiterAllowedDays() {
		List<DayOfWeek> allowedDaysList = new ArrayList<>();
		String[] allowedDaysStringArray = Settings.getString(ConfigNodes.SIEGE_START_DAY_LIMITER_ALLOWED_DAYS).toUpperCase(Locale.ROOT).replaceAll(" ", "").split(",");

			DayOfWeek allowedDay;
			for(String allowedDayString: allowedDaysStringArray) {
				allowedDay = DayOfWeek.valueOf(allowedDayString);
				allowedDaysList.add(allowedDay);
			}

		return  allowedDaysList;
	}

	public static boolean doesTodayAllowASiegeToStart() {
		if (allowedDaysList == null)
			allowedDaysList = getSiegeStartDayLimiterAllowedDays();
		return allowedDaysList.contains(LocalDate.now().getDayOfWeek());
	}

	public static boolean isWallBreachingEnabled() {
		return false;
		/*
		TODO - Re-enable when end-of-session rollbacks are implemented.
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_WALL_BREACHING_ENABLED);
		 */
	}
	
	public static double getWallBreachingPointGenerationRate() {
		return 0;
		/*
		TODO - Re-enable when end-of-session rollbacks are implemented.
		return Settings.getDouble(ConfigNodes.WAR_SIEGE_WALL_BREACHING_BREACH_POINT_GENERATION_RATE);
		 */
	}

	public static int getWallBreachingMaxPoolSize() {
		return 0;
		/*
		TODO - Re-enable when end-of-session rollbacks are implemented.
		return Settings.getInt(ConfigNodes.WAR_SIEGE_WALL_BREACHING_BREACH_POINT_GENERATION_MAX_POOL_SIZE);
		 */
	}

	public static int getWallBreachBonusBattlePoints() {
		return 0;
		/*
		TODO - Re-enable when end-of-session rollbacks are implemented.
		return Settings.getInt(ConfigNodes.WAR_SIEGE_POINTS_BALANCING_WALL_BREACH_BONUS_BATTLE_POINTS);
		 */
	}

	public static int getWallBreachingBlockPlacementCost() {
		return 0;
		/*
		TODO - Re-enable when end-of-session rollbacks are implemented.
		return Settings.getInt(ConfigNodes.WAR_SIEGE_WALL_BREACHING_PLACING_BLOCKS_COST_PER_BLOCK);
		 */
	}

	public static int getWallBreachingBlockDestructionCost() {
		return 0;
		/*
		TODO - Re-enable when end-of-session rollbacks are implemented.
		return Settings.getInt(ConfigNodes.WAR_SIEGE_WALL_BREACHING_DESTROYING_BLOCKS_COST_PER_BLOCK);
		 */
	}

	public static Set<Material> getWallBreachingPlaceBlocksWhitelist() throws TownyException
	{
		return null;
		/*
		TODO - Re-enable when end-of-session rollbacks are implemented.
		if(cachedWallBreachingPlaceBlocksWhitelist == null) {			
    		cachedWallBreachingPlaceBlocksWhitelist = EnumSet.noneOf(Material.class);
			String configuredListUppercase = Settings.getString(ConfigNodes.WAR_SIEGE_WALL_BREACHING_PLACING_BLOCKS_WHITELIST).toUpperCase(Locale.ROOT);
			for(String configuredItemUppercase: configuredListUppercase.replaceAll(" ","").split(",")) {
				if(configuredItemUppercase.startsWith("ENDSWITH=")) {
					String partialName = configuredItemUppercase.replace("ENDSWITH=","");
					for(Material material: Material.values()) {
						if(material.name().toUpperCase().endsWith(partialName))
							cachedWallBreachingPlaceBlocksWhitelist.add(material);
					}
				} else {
					Material material = Material.matchMaterial(configuredItemUppercase);
					if(material == null) {
						throw new TownyException(Translation.of("msg_error_misconfigured_place_blocks_whitelist", configuredItemUppercase));
					} else {
						cachedWallBreachingPlaceBlocksWhitelist.add(material);
					}
				}
			}
		}
		return cachedWallBreachingPlaceBlocksWhitelist;
		 */
	}

    public static boolean isWallBreachingDestroyEntityBlacklist() {
		return false;
		/*
		TODO - Re-enable when end-of-session rollbacks are implemented.

    	if(cachedWallBreachingDestroyEntityBlacklist == null) {
    		String configuredListLowercase = Settings.getString(ConfigNodes.WAR_SIEGE_WALL_BREACHING_DESTROYING_BLOCKS_BLACKLIST).toLowerCase(Locale.ROOT);
			cachedWallBreachingDestroyEntityBlacklist = configuredListLowercase.contains("is=entity"); 				
		}
		return cachedWallBreachingDestroyEntityBlacklist;
		 */
	}

	public static Set<Material> getWallBreachingDestroyBlocksBlacklist() throws TownyException {
		return null;
		/*
		TODO - Re-enable when end-of-session rollbacks are implemented.
		if(cachedWallBreachingDestroyBlocksBlacklist == null) {			
    		cachedWallBreachingDestroyBlocksBlacklist = EnumSet.noneOf(Material.class);
			String configuredListUppercase = Settings.getString(ConfigNodes.WAR_SIEGE_WALL_BREACHING_DESTROYING_BLOCKS_BLACKLIST).toUpperCase(Locale.ROOT);
			for(String configuredItemUppercase: configuredListUppercase.replaceAll(" ","").split(",")) {
				if(!configuredItemUppercase.equals("IS=ENTITY")
					&& !configuredItemUppercase.equals("IS=CONTAINER")) {
					Material material = Material.matchMaterial(configuredItemUppercase);
					if(material == null) {
						throw new TownyException(Translation.of("msg_error_misconfigured_destroy_blocks_blacklist", configuredItemUppercase));
					} else {
						cachedWallBreachingDestroyBlocksBlacklist.add(material);
					}
				}							
			}
		}
		return cachedWallBreachingDestroyBlocksBlacklist;
		 */
	}

	public static int getWallBreachingHomeblockBreachHeightLimitMin() {
		return 0;
		/*
		TODO - Re-enable when end-of-session rollbacks are implemented.
		return Settings.getInt(ConfigNodes.WAR_SIEGE_WALL_BREACHING_HOMEBLOCK_BREACH_HEIGHT_LIMITS_MIN);
		 */
	}
	
	public static int getWallBreachingHomeblockBreachHeightLimitMax() {
		return 0;
		/*
		TODO - Re-enable when end-of-session rollbacks are implemented.
		return Settings.getInt(ConfigNodes.WAR_SIEGE_WALL_BREACHING_HOMEBLOCK_BREACH_HEIGHT_LIMITS_MAX);
		 */
	}

	public static boolean isWallBreachingCannonsIntegrationEnabled() {
		return false;
		/*
		TODO - Re-enable when end-of-session rollbacks are implemented.
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_WALL_BREACHING_CANNONS_INTEGRATION_ENABLED);
		 */
	}

	public static double getWallBreachingCannonFirePointGenerationRate() {
		return 0;
		/*
		TODO - Re-enable when end-of-session rollbacks are implemented.
		return Settings.getDouble(ConfigNodes.WAR_SIEGE_WALL_BREACHING_CANNONS_INTEGRATION_BREACH_POINT_GENERATION_RATE_FROM_CANNON_FIRE);
		 */
	}

	public static int getWallBreachingCannonExplosionCostPerBlock() {
		return 0;
		/*
		TODO - Re-enable when end-of-session rollbacks are implemented.
		return Settings.getInt(ConfigNodes.WAR_SIEGE_WALL_BREACHING_CANNONS_INTEGRATION_EXPLODING_BLOCKS_COST_PER_BLOCK);
		 */
	}

	public static int getSiegeBalanceCapValue() {
		return Settings.getInt(ConfigNodes.WAR_SIEGE_POINTS_SIEGE_BALANCE_CAP_VALUE);
	}

	public static boolean getKillPlayersWhoLogoutInSiegeZones() {
		return Settings.getBoolean(ConfigNodes.WAR_SIEGE_KILL_PLAYERS_WHO_LOG_OUT_IN_SIEGE_ZONES);
	}

	public static boolean isStopTownyPlotPvpProtection() {
		return Settings.getBoolean(ConfigNodes.PVP_PROTECTION_OVERRIDES_STOP_TOWNY_PLOT_PVP_PROTECTION);
	}

	public static boolean isStopTownyFriendlyFireProtection() {
		return Settings.getBoolean(ConfigNodes.PVP_PROTECTION_OVERRIDES_STOP_TOWNY_FRIENDLY_FIRE_PROTECTION);
	}

	public static boolean isStopAllPvpProtection() {
		return Settings.getBoolean(ConfigNodes.PVP_PROTECTION_OVERRIDES_STOP_ALL_PVP_PROTECTION);
	}

	public static List<LocalDateTime> getAllBattleSessionStartTimesForToday() {
		return getAllBattleSessionStartTimesForDay(LocalDate.now());
	}

	@Nullable
	public static LocalDateTime getFirstBattleSessionStartTimeForTomorrowUtc() {
		LocalDate tomorrow = LocalDate.now().plusDays(1);
		List<LocalDateTime> allBattleSessionStartTimesForTomorrow = getAllBattleSessionStartTimesForDay(tomorrow); 
		if(allBattleSessionStartTimesForTomorrow.size() != 0) {
			return allBattleSessionStartTimesForTomorrow.get(0);
		} else {
			return null;
		}
	}

	private static List<LocalDateTime> getAllBattleSessionStartTimesForDay(LocalDate day) {
		//Determine if the given day is on the weekend
		boolean isWeekend = day.getDayOfWeek() == DayOfWeek.SATURDAY || day.getDayOfWeek() == DayOfWeek.SUNDAY;

		//Get the start times from the config file, in the form of a single string.
		String startTimesAsString = isWeekend ? 
			getWarSiegeBattleSessionWeekendStartTimes() :
			getWarSiegeBattleSessionWeekdayStartTimes();

		//Transform the config file strings into a list of LocalDateTime objects
		List<LocalDateTime> startTimesAsList = new ArrayList<>();	
		if(startTimesAsString.length() > 0) {		
			String[] startTimeAsHourMinutePair;		
			LocalDateTime startTime;
			for(String startTimeAsString: startTimesAsString.split(",")) {
				if (startTimeAsString.contains(":")) {
					startTimeAsHourMinutePair = startTimeAsString.split(":");
					startTime = LocalDateTime.of(day, LocalTime.of(Integer.parseInt(startTimeAsHourMinutePair[0]), Integer.parseInt(startTimeAsHourMinutePair[1])));
				} else {
					startTime = LocalDateTime.of(day, LocalTime.of(Integer.parseInt(startTimeAsString), 0));
				}
				startTimesAsList.add(startTime);	
			}
		}
		return startTimesAsList;
	}

	public static String getWarSiegeBattleSessionWeekdayStartTimes() {
		return Settings.getString(ConfigNodes.BATTLE_SESSION_SCHEDULER_START_TIMES_WEEKDAYS);
	}

	public static String getWarSiegeBattleSessionWeekendStartTimes() {
		return Settings.getString(ConfigNodes.BATTLE_SESSION_SCHEDULER_START_TIMES_WEEKEND_DAYS);
	}

	public static int getWarSiegeBattleSessionsDurationMinutes() {
		return Settings.getInt(ConfigNodes.BATTLE_SESSION_SCHEDULER_DURATION_MINUTES);
	}

	public static boolean cancelBattleSessionWhenNoActiveSieges() {
		return Settings.getBoolean(ConfigNodes.BATTLE_SESSION_SCHEDULER_CANCEL_SESSION_WHEN_NO_SIEGES);
	}

	// Make sure that the config has been given a valid PotionEffectType or Enchantment name.
    private static boolean validEffect(Material material, String name) {
        return !name.isEmpty() && (name.equalsIgnoreCase("custom_effect") || isValid(material, name));
    }

    private static boolean isValid(Material material, String name) {
        return (isPotionBased(material) && validatePotionEffectType(name))
            || (!isPotionBased(material) && validateEnchantmentType(name));
    }

    private static boolean validateEnchantmentType(String enchantSpec) {
        return Enchantment.getByKey(NamespacedKey.fromString("minecraft:"+ enchantSpec)) != null;
    }

    private static boolean validatePotionEffectType(String effectSpec) {
        return PotionEffectType.getByName(effectSpec) != null;
    }

    private static boolean isPotionBased(Material material) {
        return material == Material.POTION
                || material == Material.SPLASH_POTION
                || material == Material.LINGERING_POTION
                || material == Material.TIPPED_ARROW;
    }

	private static PotionEffect generatePotionEffect(String[] effectSpec) {
		PotionEffectType potionEffectType = PotionEffectType.getByName(effectSpec[0]);
		int amplifier = Integer.parseInt(effectSpec[1]);
		int duration = Integer.parseInt(effectSpec[2]) * 20;  //Multiply by 20 to convert seconds to ticks
		boolean particles = Boolean.parseBoolean(effectSpec[3]);
		boolean ambient = Boolean.parseBoolean(effectSpec[4]);
		boolean icon = Boolean.parseBoolean(effectSpec[5]);
		return new PotionEffect(potionEffectType, duration, amplifier, particles, ambient, icon);
	}

	public static boolean isBlockGlitchingPreventionEnabled() {
		return Settings.getBoolean(ConfigNodes.BLOCK_GLITCHING_PREVENTION_ENABLED);
	}

	public static int getBlockGlitchingTeleportDelayMillis() {
		return Settings.getInt(ConfigNodes.BLOCK_GLITCHING_PREVENTION_TELEPORT_DELAY_MILLIS);
	}
}
