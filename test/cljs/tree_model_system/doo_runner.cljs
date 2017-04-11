(ns tree-model-system.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [tree-model-system.core-test]))

(doo-tests 'tree-model-system.core-test)

