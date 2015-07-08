/**
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.roaster.model.impl;

import java.util.Collections;
import java.util.List;

import org.jboss.forge.roaster.model.JavaType;
import org.jboss.forge.roaster.model.JavaUnit;
import org.jboss.forge.roaster.model.util.Assert;

/**
 * A builder for {@link JavaUnit} objects
 * 
 * @author <a href="mailto:ggastald@redhat.com">George Gastaldi</a>
 */
@SuppressWarnings("unchecked")
public class JavaUnitImpl implements JavaUnit
{
   private final List<JavaType<?>> declaredTypes;

   public JavaUnitImpl(List<JavaType<?>> declaredTypes)
   {
      Assert.isTrue(declaredTypes != null && !declaredTypes.isEmpty(), "Declared types should not be null nor empty");
      this.declaredTypes = Collections.unmodifiableList(declaredTypes);
   }

   @Override
   public JavaType<?> getGoverningType()
   {
      return declaredTypes.get(0);
   }

   @Override
   public List<JavaType<?>> getTopLevelTypes()
   {
      return declaredTypes;
   }

   @Override
   public String toString()
   {
      return getGoverningType().toString();
   }

   @Override
   public String toUnformattedString()
   {
      return getGoverningType().toUnformattedString();
   }
}
